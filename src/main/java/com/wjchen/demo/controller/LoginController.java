package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import com.wjchen.demo.common.utils.Result;
import com.wjchen.demo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
//    @RequestMapping("/index")
//    public String index2(){
//        return "index";
//    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "page/login/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(User user, HttpServletRequest request){
        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 3.执行登录方法
        try{
            subject.login(token);
            return success("登录成功");
        } catch (UnknownAccountException e){
//            result.put("msg","用户名不存在！");

        } catch (IncorrectCredentialsException e){
//            result.put("msg","密码错误！");
        }
        return fail("账号或密码错误！");
    }
    /**
     * 跳后台首页
     */

    @RequestMapping("/main")
    public String main(){
        return "page/main";
    }

    @RequestMapping("/newsList")
    public String newsList(){
        return "page/news/newsList";
    }
}
