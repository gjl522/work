package com.isoftstone.lsfile.file.controller;

import com.isoftstone.lsfile.file.bean.FileInfo;
import com.isoftstone.lsfile.file.bean.Result;
import com.isoftstone.lsfile.file.service.FileService;
import com.isoftstone.lsfile.utils.LsException;
import com.isoftstone.lsfile.utils.ResultTool;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;


/**
 * 文件服务controller
 *
 * @author gongjiale
 * @date 2020-8-25
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    /**
     * 文件存储位置
     */
    @Value("${file-server-path}")
    private String fileServerPath;

    @Resource
    FileService fileService;

    private final String KEY_PATTEN = "^[A-Za-z0-9]+$";

    /**
     * 启动
     */
    @GetMapping("getSuccess")
    @ApiOperation("测试启动是否成功！")
    public String getSuccess() {
        return "start success";
    }

    /**
     * 上传文件
     *
     * @param key
     * @param multipartFile
     * @return
     */
    @PostMapping("upLoad")
    @ResponseBody
    @ApiOperation("上传文件")
    public Result upLoad(String key, @RequestParam("file") MultipartFile multipartFile) {
            if (!Pattern.matches(KEY_PATTEN, key)) {
            return ResultTool.failed();
        }
        FileInfo fileInfo = fileService.upLoad(key, multipartFile);
        return ResultTool.successData(fileInfo);
    }

    /**
     * 下载文件
     *
     * @param id
     */
    @GetMapping("downLoad/{id}")
    @ResponseBody
    @ApiOperation("下载文件")
    public ResponseEntity<byte[]> downLoad(@NotNull @PathVariable("id") String id) {
        try {
            // 附件id解密
          //  Long idL = Long.parseLong(AES128Util.decode(id));

            // 查询附件相关信息
            FileInfo fileInfo = fileService.getFileInfoById(Long.valueOf(id));
            String fileName = new String(fileInfo.getRealName().getBytes("utf-8"), "ISO-8859-1");
            String filePath = fileInfo.getFilePath();

            File file = new File(fileServerPath + File.separator + filePath);
            if (!file.exists() || !file.isFile()) {
                //log.error("文件不存在" + file.getPath());
                HttpHeaders jsonUtfHeard = new HttpHeaders();
                //使得浏览器根据不同的数据类型进行分类处理
                jsonUtfHeard.setContentType(MediaType.APPLICATION_JSON_UTF8);
                throw new LsException(404, "资源不存在", "file not fount");
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //log.info("附件：{}，被下载", fileName);
            return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),
                    headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        }/* finally {

        }*/
        return null;
    }
    @PostMapping("uploadCloud")
    @ApiOperation("上传文件至华为云")
    @ResponseBody
    public Result UpLoadCloud(/*@RequestParam(value = "file", required = false) MultipartFile multipartFile*/){

      //  ObsClient obsClient = new ObsClient(FileConstant.AK, FileConstant.SK, FileConstant.END_POINT);




        return null;
    }

}
