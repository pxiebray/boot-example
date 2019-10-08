package com.ztest.boot.mvc.resource;

import com.ztest.boot.mvc.common.Permission;
import com.ztest.boot.mvc.common.Statistics;
import com.ztest.boot.mvc.common.exception.BusinessException;
import com.ztest.boot.mvc.common.exception.FatalException;
import com.ztest.boot.mvc.common.exception.GlobalExceptionAdvice;
import com.ztest.boot.mvc.entity.DemoInfo;
import com.ztest.boot.mvc.manager.CustomResourceManager;
import com.ztest.boot.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @Controller =  Http接口类
 * @ResponseBody = 返回body数据
 * @RequestMapping指定路径 </br>
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class DemoResource {

    private Integer count = 0;

    @Autowired
    private CustomResourceManager customResourceManager;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private DemoService demoService;

    @Permission("getDemo")
    @Statistics("args[0]")
    @RequestMapping(value = "/demos/{id}", method = RequestMethod.GET)
    public String getDemo(@PathVariable("id") Integer id, DemoInfo demoInfo, HttpServletRequest request) {

        demoService.getName("");

        System.out.println(demoInfo.toString());
        System.out.println(request.getMethod());
        long sum = 0;
        for (int i = 0; i < id; i++) {
            sum += i;
        }
        return "sum " + sum;
    }

    @Statistics("args[0]")
    @RequestMapping(value = "/demos/{id}", method = RequestMethod.POST)
    public String addDemo(@PathVariable Integer id) {
        return "add demo " + id;
    }

    @RequestMapping(value = "/demos/{id}", method = RequestMethod.PUT)
    public String putDemo(@PathVariable Integer id) {
        return "update demo " + id;
    }

    @RequestMapping(value = "/demos/{id}", method = RequestMethod.DELETE)
    public String deleteDemo(@PathVariable Integer id) {
        return "delete demo " + id;
    }

    /**
     * ExceptionHandler只对当前Resource接口有效
     * 当接收Exception时优先级高于Advice，自定义类型时低于Advice的Exception
     *
     * @param e
     * @return
     * @see GlobalExceptionAdvice
     */
    @Deprecated
    @ExceptionHandler({FatalException.class})
    public String exception(FatalException e) {
        return "ExceptionHandler in controller";
    }

    @RequestMapping(value = "/demos/exception/1", method = RequestMethod.GET)
    public String returnException(@PathVariable("id") Integer id) {
        Long.parseLong("a");
        return "returnException";
    }

    @RequestMapping(value = "/demos/exception/2", method = RequestMethod.GET)
    public String returnBusiException(@PathVariable("id") Integer id) {
        try {
            Long.parseLong("a");
        } catch (Exception e) {
            throw new BusinessException();
        }
        return "returnBusiException";
    }

    @RequestMapping(value = "/demos/exception/3", method = RequestMethod.GET)
    public String returnFatalException(@PathVariable("id") Integer id) {
        try {
            Long.parseLong("a");
        } catch (Exception e) {
            throw new FatalException();
        }
        return "returnFatalException";
    }
}
