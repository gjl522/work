package com.isoftstone.lsfile.file.service;

import com.isoftstone.lsfile.file.bean.FileInfo;
import com.isoftstone.lsfile.file.dao.FileDao;
import com.isoftstone.lsfile.utils.LsException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 文件服务serviceImpl
 *
 * @author tabghuibo 120732
 * @date 2018-10-18
 */
@Service("fileService")
public class FileServiceImpl implements FileService {

    /**
     * 文件存储路径
     */
    @Value("${file-server-path}")
    private String fileServerPath;


    @Resource
    FileDao fileDao;

    /**
     * 上传文件
     *
     * @param key
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FileInfo upLoad(String key, MultipartFile multipartFile) {
        FileInfo fileInfo = new FileInfo();
        String fileName = multipartFile.getOriginalFilename();
        fileInfo.setRealName(fileName);

        //获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        //设置文件名
        fileInfo.setFilePath(getRandFileName(key, suffix));
        fileInfo.setKey(key);
        //保存文件
        try {
            File outFile = new File(fileServerPath + File.separator + fileInfo.getFilePath());
            FileUtils.forceMkdirParent(outFile);
            Files.write(Paths.get(outFile.toURI()), multipartFile.getBytes());
            insertRecord(fileInfo);
            return fileInfo;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LsException("文件不存在", "file does not exist");
        } catch (IOException e) {
            e.printStackTrace();
            throw new LsException("io异常", "IO Exception");
        }

    }

    /**
     * 通过id获取文件信息
     *
     * @param id
     * @return
     */
    @Override
    public FileInfo getFileInfoById(Long id) {
        return fileDao.getFileInfoById(id);
    }

    /**
     * 插入文件上传记录
     *
     * @param fileInfo
     */
    private void insertRecord(FileInfo fileInfo) {
      /*  LoginUserInfo loginUserInfo = SubjectUtil.getLoginUserInfo();
        if (loginUserInfo != null) {
            fileInfo.setCreateUser(loginUserInfo.getId());
        }
        //获取服务器信息
        try {
            InetAddress addr = InetAddress.getLocalHost();
            fileInfo.setHostName(addr.getHostName());
            fileInfo.setIp(addr.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
*/
        fileDao.insertRecord(fileInfo);
    }

    /**
     * 审查文件名 key/日期/文件名
     *
     * @param key
     * @param suffix
     * @return
     */
    private String getRandFileName(String key, String suffix) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return key + File.separator + dateFormat.format(new Date()) + File.separator + UUID.randomUUID() + "." + suffix;
    }
}
