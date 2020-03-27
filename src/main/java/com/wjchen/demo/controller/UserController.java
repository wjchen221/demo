package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    @ResponseBody
    public String saveUser(User user){
        userService.save(user);
        return "ok!";
    }

    @RequestMapping("getById")
    @ResponseBody
    public String getById(String id){
        User byId = userService.getById(id);
        System.out.println(byId);
        return "byId";
    }

}
