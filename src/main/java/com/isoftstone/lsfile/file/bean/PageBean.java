package com.isoftstone.lsfile.file.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.isoftstone.lsfile.utils.ResultTool;

import java.util.List;

/**
 * @author gongjiale
 * @date 2018/8/25 16:04
 */
public interface PageBean {

    static Result getFailedPageBean() {
        return ResultTool.failed();
    }
}
