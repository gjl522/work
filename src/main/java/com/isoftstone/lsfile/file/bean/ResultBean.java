package com.isoftstone.lsfile.file.bean;


import com.isoftstone.lsfile.utils.ResultTool;

public interface ResultBean {
    static Result getSuccessResultBean() {
        return ResultTool.success();
    }

    static ResultBean getFailedResultBean() {
        return ResultTool.failed();
    }
}
