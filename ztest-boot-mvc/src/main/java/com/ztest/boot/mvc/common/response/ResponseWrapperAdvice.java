package com.ztest.boot.mvc.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztest.boot.mvc.common.exception.FatalException;
import com.ztest.boot.mvc.common.response.Response;
import com.ztest.boot.mvc.common.response.ResponseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 统一返回包装
 * 当方法的返回类型为String时，序列化发生类型转换错误，
 * 参考解决@link {https://www.aliyun.com/jiaocheng/774152.html}
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 44
 */
@ControllerAdvice(basePackages = "com.ztest.boot.mvc.resource")
public class ResponseWrapperAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof Response) {
            return body;
        }

        Response<Object> wrapResponse = new Response(true, ResponseConstant.SUCCESS.getCode(),
                "", "", body);
        try {
            if (body instanceof String) {
                return objectMapper.writeValueAsString(wrapResponse);
            }
        } catch (JsonProcessingException e) {
            throw new FatalException();
        }

        return wrapResponse;
    }
}
