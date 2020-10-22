package com.isoftstone.lsfile.file.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件服务实体
 *
 * @author gongjiale
 * @date 2020-8-25
 */
@Data
public class FileInfo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 存储位置hostName
     */
    private String hostName;

    /**
     * 文件类型
     */
    private String KeyId;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 真实名称
     */
    private String realName;

    /**
     * 服务器ip
     */
    private String ip;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String createDate;

    /**
     * 创建人
     */
    private Long createUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getKey() {
        return KeyId;
    }

    public void setKey(String keyId) {
        KeyId = keyId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", hostName='" + hostName + '\'' +
                ", KeyId='" + KeyId + '\'' +
                ", filePath='" + filePath + '\'' +
                ", realName='" + realName + '\'' +
                ", ip='" + ip + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createUser=" + createUser +
                '}';
    }
}
