package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import com.wjchen.demo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @date 2020/04/17 16:00
 */
@Controller
@RequestMapping("task")
public class TaskController extends BaseController<Task> {

    @RequestMapping("list")
    public String list(){
        return "pages/task/list";
    }
}
