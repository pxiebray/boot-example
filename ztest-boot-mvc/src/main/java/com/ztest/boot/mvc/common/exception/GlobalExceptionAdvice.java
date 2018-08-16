package com.ztest.boot.mvc.common.exception;

import com.ztest.boot.mvc.common.exception.BusinessException;
import com.ztest.boot.mvc.common.exception.FatalException;
import com.ztest.boot.mvc.common.response.Response;
import com.ztest.boot.mvc.common.response.ResponseConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/13 0013 13
 */
@ControllerAdvice(basePackages = "com.ztest.boot.mvc.resource")
public class GlobalExceptionAdvice {

    /**
     * SpringMVC 异常处理方式：
     * 1，controller级别，ExceptionHandler只对当前Resource接口有效
     * 2，全局级别，使用@ControllerAdvice增强，被@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法，会作用在所有被@RequestMapping 注解的方法上。
     * 3，全局级别，继承？
     *
     * Exception文档：@link{https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-exceptionhandler}
     * Advice文档：@link{https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-controller-advice}
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseEntity<Object> exceptionHander(Exception e) {
        Response<Object> response = null;
        HttpStatus status = HttpStatus.OK;
        if (e instanceof BusinessException) {
            status = HttpStatus.BAD_REQUEST;
            response = new Response(false, ResponseConstant.BUSY_EXCEPTION.getCode(), "msg","errorMsg", "data");
        } else if (e instanceof FatalException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new Response(false, ResponseConstant.SYS_EXCEPTION.getCode(), "msg","errorMsg", "data");
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new Response(false, ResponseConstant.SYS_EXCEPTION.getCode(), "msg",e.getMessage(), "data");
        }

        return new ResponseEntity(response, status);
    }
}
