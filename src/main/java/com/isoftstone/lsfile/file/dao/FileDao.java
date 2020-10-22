package com.isoftstone.lsfile.file.dao;

import com.isoftstone.lsfile.file.bean.FileInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件服务Dao
 * @author gongjiale
 * @date 2020-8-25
 */
@Mapper
public interface FileDao {
    /**
     * 插入文件信息到数据库
     * @param fileInfo
     */
    void insertRecord(FileInfo fileInfo);

    /**
     * 获取文件信息
     * @param id
     * @return
     */
    FileInfo getFileInfoById(Long id);
}
