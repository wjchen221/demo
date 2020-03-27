package com.wjchen.demo.controller;

import com.wjchen.demo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "page/login/login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 3.执行登录方法
        try{
            subject.login(token);
            return "redirect:/index";
        } catch (UnknownAccountException e){
            e.printStackTrace();
            request.setAttribute("msg","用户名不存在！");
        } catch (IncorrectCredentialsException e){
            request.setAttribute("msg","密码错误！");
        }
        return "login";
    }
}
