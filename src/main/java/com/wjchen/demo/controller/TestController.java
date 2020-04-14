package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController extends BaseController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        Map<String,Object> paramMap = getParamMap();
        return "wjchen221";
    }

}
