package com.wjchen.demo.base;


import com.wjchen.demo.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


@Controller
public abstract class BaseController<T> {
    protected Logger LOGGER= LoggerFactory.getLogger(this.getClass());

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
     * 自定义success返回 DATA
     */
    public Result success(String msg,Object DATA){
        return new Result(msg,DATA);
    }

    /**
     * 操作失败
     */
    public Result fail(){
        return new Result("400","操作失败",null);
    }

    /**
     * 自定义失败消息
     */
    public Result fail(String msg){
        return new Result("400",msg,null);
    }


    /**
     * 自定义返回
     */
    public Result result(String code,String msg,Object DATA){
        return new Result(code,msg,DATA);
    }
    /******   返回数据 end   *******/
}
