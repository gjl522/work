package com.isoftstone.lsfile.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *定义obs实体类
 */
@Data
public class fileObsEntity implements Serializable {

    private String operatorType;
    private String objectEndpoint;
    private String objectBucket;
    private String objectAk;
    private String objectSk;


}
