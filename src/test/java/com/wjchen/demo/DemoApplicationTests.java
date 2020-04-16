package com.wjchen.demo;

import com.wjchen.demo.common.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Test
    public void test(){
        boolean set = redisUtil.set("a", "this is a");
        Object a = redisUtil.get("a");
        System.out.println(a.toString());
    }

    @Test
    public void test2(){
        taskScheduler.schedule(()->{
            System.out.println("=====执行动态定时任务test=====");
        },new CronTrigger("0/10 * * * * ?"));
    }
}
