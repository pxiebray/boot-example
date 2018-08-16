package com.ztest.boot.mvc.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztest.boot.mvc.common.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 15
 */
@Deprecated
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    public GlobalExceptionHandler() {
        System.out.println("1");
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        try {
            response.setStatus(HttpStatus.OK.value()); //设置状态码
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
            response.setCharacterEncoding("UTF-8"); //避免乱码

            Response<Object> body = new Response<>("data");
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

            response.getWriter().write(objectMapper.writeValueAsString(body));
            response.setStatus(status.value());
        } catch (Exception _e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
