package com.wjchen.demo.controller;

import com.wjchen.demo.base.BaseController;
import com.wjchen.demo.schedule.DynamicScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Controller
public class TestController extends BaseController {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;


    @RequestMapping("start")
    @ResponseBody
    public void start(String name,String corn){
        ScheduledFuture<?> schedule = taskScheduler.schedule(()->{
            LOGGER.info("=====执行动态定时=====name = "+name);
        }, new CronTrigger(corn == null ? "0/10 * * * * ?" : corn));
        DynamicScheduleTask.taskMap.put(name,schedule);
    }

    @RequestMapping("stop")
    @ResponseBody
    public void stop(String name){
        ScheduledFuture<?> scheduledFuture = DynamicScheduleTask.taskMap.get(name);
        scheduledFuture.cancel(true);
    }

}
