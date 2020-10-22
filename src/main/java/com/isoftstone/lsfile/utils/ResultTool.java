package com.isoftstone.lsfile.utils;


import com.isoftstone.lsfile.file.bean.Language;
import com.isoftstone.lsfile.file.bean.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息工具类
 * @author linxin
 */
public class ResultTool {

    /**
     * 成功
     *
     * @return
     */
    public static Result success() {
        return new Result(true, null, null);
    }

    /**
     * 带提示成功
     *
     * @param i18Msgs
     * @return
     */
    public static Result success(Map<Language, String> i18Msgs) {
        return new Result(true, i18Msgs, null);
    }

    /**
     * 带提示成功
     *
     * @param msg
     * @return
     */
    public static Result success(String... msg) {
        return new Result(true, makeI18Msg(msg), null);
    }


    /**
     * 带数据成功
     *
     * @param t
     * @return
     */
    public static <T> Result<T> successData(T t) {
        return new Result(true, null, t);
    }
    /**
     * 带数据成功
     *
     * @param t
     * @return
     */
    public static <T> Result<T> successData(T t,String msg) {
        return new Result(true, makeI18Msg(msg), t);
    }
    /**
     * 失败
     *
     * @return
     */
    public static Result failed() {
        return new Result(false, null, null);
    }

    /**
     * 带提示失败
     *
     * @param i18Msgs
     * @return
     */
    public static Result failed(Map<Language, String> i18Msgs) {

        return new Result(false, i18Msgs, null);
    }

    /**
     * 带提示失败
     *
     * @param msg
     * @return
     */
    public static Result failed(String... msg) {
        return new Result(false, makeI18Msg(msg), null);
    }


    /**
     * 带数据失败
     *
     * @param t
     * @return
     */
    public static Result failedData(Object t) {
        return new Result(false, null, t);
    }

    /**
     * 将字符串数组转换为国际化提示
     *
     * @param msg
     * @return
     */
    public static Map<Language, String> makeI18Msg(String... msg) {
        Map<Language, String> i18Msgs = new HashMap<>();
        Language[] languages = Language.values();
        int len = msg.length;
        len = languages.length > len ? len : languages.length;
        for (int i = 0; i < len; i++) {
            i18Msgs.put(languages[i], msg[i]);
        }
        return i18Msgs;
    }


    public static Result failed(Object data, String... message) {
        Result result = failed(message);
        result.setData(data);
        return result;
    }
}
