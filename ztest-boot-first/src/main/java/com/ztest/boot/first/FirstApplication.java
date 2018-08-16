package com.ztest.boot.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 四大神器
 * 1, autoconfig
 * 2, starters
 * 3, actuator
 * 4, cli
 *
 * @author pxie
 * @version 1.0
 * @data 2018/7/5 0005 26
 */
@SpringBootApplication
public class FirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }


}
