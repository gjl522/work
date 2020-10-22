package com.isoftstone.lsfile.file.service;
import com.isoftstone.lsfile.file.bean.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务Service
 * @author gongjiale
 * @date 2018-8-25
 */
@Mapper
public interface FileService {
    FileInfo upLoad(String key, MultipartFile multipartFile);

    FileInfo getFileInfoById(Long id);
}
