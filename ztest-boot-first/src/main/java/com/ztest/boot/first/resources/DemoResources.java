package com.ztest.boot.first.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @version 1.0
 * @data 2019/4/22 0022 28
 */
@RestController
public class DemoResources {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/")
    public String demo() {
        return "hello world!";
    }

}
