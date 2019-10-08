package com.ztest.boot.mvc.service.impl;

import com.ztest.boot.mvc.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/12/19 0019 03
 */
@Service
public class DemoServiceImpl implements DemoService {

    public void getName(String id) {
        System.out.println("hello " + id);
    }
}
