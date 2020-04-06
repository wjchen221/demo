package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import com.wjchen.demo.common.utils.Result;
import com.wjchen.demo.model.User;
import com.wjchen.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @PostMapping("user")
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

    @GetMapping("users")
    @ResponseBody
    public Result getList(User user){
        Pageable pageable = PageRequest.of(getInt("page")-1,getInt("limit"),Sort.by(Sort.Direction.ASC,"id"));
        Result result = userService.getPage(pageable, user);
        return result;
    }

}
