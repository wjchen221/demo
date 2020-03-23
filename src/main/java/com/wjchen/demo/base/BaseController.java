package com.wjchen.demo.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


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

    /**
     * 获取所有参数
     * @return
     */

    protected Map<String,String> getParamMap(){
        Map<String,String> parameters = new HashMap<String, String>();
        Map map = getRequest().getParameterMap();
        Set keys = map.keySet();
        for(Object key : keys){
            parameters.put(key.toString(),getRequest().getParameter(key.toString()));
        }
        return parameters;
    }

    /**
     * 获取单个参数值
     * @param name
     * @return
     */
    public String getString(String name) {
        return getString(name,null);
    }

    /**
     * 获取单个参数值
     * @param name  参数名
     * @param defaultValue  默认值
     * @return
     */
    public String getString(String name, String defaultValue) {
        String resultStr = getRequest().getParameter(name);
        if (resultStr == null || "".equals(resultStr)|| "null".equals(resultStr) || "undefined".equals(resultStr)) {
            return defaultValue;
        }
        return resultStr;
    }
}
