package com.isoftstone.lsfile.file.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回信息类
 * @author gongjiale
 * @date 2020-8-25
 */
public class Result<T> implements Serializable, ResultBean, PageBean {

    /**
     * true：成功 false：失败
     */
    @ApiModelProperty("是否成功 true:成功 false:失败")
    private boolean ok;

    /**
     * 国际化提示
     */
    @ApiModelProperty("国际化提示 cn:中文提示 en:英文提示")
    private Map<Language, String> i18Msgs;


    /**
     * 数据
     */
    @ApiModelProperty("返回数据")
    private T data;

    public Result() {

    }


    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<Language, String> getI18Msgs() {
        return i18Msgs;
    }

    /**
     * 构造函数
     *
     * @param ok
     * @param i18Msgs
     * @param data
     */
    public Result(boolean ok, Map<Language, String> i18Msgs, T data) {
        this.ok = ok;
        this.i18Msgs = i18Msgs;
        this.data = data;
    }

    public String getCode() {
        if(isOk()) {
            return "SUCCESS";
        } else {
            return "FAILD";
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok=" + ok +
                ", i18Msgs=" + i18Msgs +
                ", data=" + data +
                '}';
    }
}
