package com.wjchen.demo.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


@Controller
public abstract class BaseController<T> {
    protected Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    /**
     * 要获取oss的上传路径的方法
     */

}
