package com.isoftstone.lsfile.utils;


import com.isoftstone.lsfile.file.bean.Language;

import java.util.Map;

/**
 * 统一异常定义
 * @author gongjiale
 * @date 2020/8/25 17:34
 */
public class LsException extends RuntimeException
{

    /**
     * 国际化提示
     */
    private Map<Language, String> i18Msgs;

    /**
     * 状态码
     */
    private Integer code;

    public LsException() {

    }

    public LsException(Map<Language, String> i18Msgs) {
        super();
        this.i18Msgs = i18Msgs;
    }

    public LsException(String... s) {
        super();
        this.i18Msgs = ResultTool.makeI18Msg(s);
    }

    public LsException(int i, String... msg) {
        this.code = i;
        this.i18Msgs = ResultTool.makeI18Msg(msg);
    }


    public Map<Language, String> getI18Msgs() {
        return i18Msgs;
    }

    public void setI18Msgs(Map<Language, String> i18Msgs) {
        this.i18Msgs = i18Msgs;
    }

    public String getCnMsg() {
        return i18Msgs == null ? "" : i18Msgs.get(Language.cn);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEnMsg() {
        return i18Msgs == null ? "" : i18Msgs.get(Language.en);
    }
}