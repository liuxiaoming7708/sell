package com.payease;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiaoming on 2017/11/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class LoggerTest {

    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
       // logger.debug("debug ...");
       // logger.info("info ...");
       // logger.error("error ...");
        //日志中打印变量的使用样例

        String name = "liuxiaoming";
        String password = "123456";
        log.debug("debug ..."); //@Slf4j
        log.info("info ..."+"name:" + name + " ,password:" + password);   //@Slf4j
        log.error("error ..."+"name:{} ,password:{}",name,password); //@Slf4j
    }

    @Test
    public void test2(){
        String s = "64";
        String d[] = s.split(",");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < d.length; i++) {
            list.add(d[i]);

        }
        System.out.println(list);
    }
}
