package com.wjchen.demo.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    /**
     * 响应码
     */
    private String code = "0";

    /**
     * 响应的信息
     */
    private String msg="操作成功";

    /**
     * 响应的数据
     */
    private Object DATA;

    /**
     *
     */
    private long count;

    /**
     * 响应的时间戳
     */
    private long time = System.currentTimeMillis();

    public Result(String code, String msg, Object DATA,long count) {
        this.code = code;
        this.msg = msg;
        this.DATA = DATA;
        this.count=count;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDATA() {
        return DATA;
    }

    public void setDATA(Object DATA) {
        this.DATA = DATA;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
