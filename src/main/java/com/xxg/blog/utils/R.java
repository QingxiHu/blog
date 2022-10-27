package com.xxg.blog.utils;

import org.apache.hc.core5.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @time 2022/10/19 14:04
 * @Author SmallWatermelon
 * @since 1.8
 */
public class R extends HashMap<String, Object> {

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        //SC_INTERNAL_SERVER_ERROR = 500;
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常， 请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    private static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok() {
        return new R();
    }

    private static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    private static R ok(Map< String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
