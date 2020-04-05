package com.wjchen.demo;

import com.wjchen.demo.common.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        boolean set = redisUtil.set("a", "this is a");
        Object a = redisUtil.get("a");
        System.out.println(a.toString());
    }
}
