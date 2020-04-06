package com.wjchen.demo.base;


import com.wjchen.demo.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public abstract class BaseController<T> {
    protected Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    /**
     * 获取request
     * @return
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

    }

    public String getString(String name) {
        return getString(name, null);
    }

    public String getString(String name, String defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr)
                || "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        }else{
            return resultStr;
        }
    }

    public int getInt(String name) {
        return getInt(name, 0);
    }

    public int getInt(String name, int defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr != null) {
            try {
                return Integer.parseInt(resultStr);
            } catch (Exception e) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    /***********   oss        ****************/
    /**
     * 要获取oss的上传路径的方法
     */

    /******   返回数据 result   *******/
    /**
     *  操作成功
     */
    public Result success(){
        return new Result();
    }

    /**
     * 自定义成功消息
     */
    public Result success(String msg){
        return new Result(msg);
    }

    /**
     * 自定义success返回 DATA dai msg
     */
    public Result success(Object data,int count,String msg){
        return new Result("0",msg,data,count);
    }

    /**
     * 自定义success返回 DATA dai
     */
    public Result success(Object data,Long count){
        return new Result("0","操作成功",data,count);
    }

    /**
     * 自定义返回
     */
    public Result result(String code,String msg,Object DATA,int count){
        return new Result(code,msg,DATA,count);
    }

    /**
     * 操作失败
     */
    public Result fail(){
        return new Result("400","操作失败",null,0);
    }

    /**
     * 自定义失败消息
     */
    public Result fail(String msg){
        return new Result("400",msg,null,0);
    }

    /******   返回数据 end   *******/
}
