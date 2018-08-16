package com.ztest.boot.mvc.manager;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/5 0005 28
 */
@Component
public class CustomResourceManager {

    @Autowired
    WebApplicationContext context;

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

//    @Autowired
//    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public void get() {
        //获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(context,
                HandlerMapping.class, true, false);

        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping rmhm = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
                for (RequestMappingInfo rmi : handlerMethods.keySet()) {
                    PatternsRequestCondition prc = rmi.getPatternsCondition();
                    Set<String> patterns = prc.getPatterns();
                    HandlerMethod handlerMethod = handlerMethods.get(rmi);
                    for (String url : patterns) {
                        Class<?> clazz = handlerMethod.getBeanType();
                        Method method = handlerMethod.getMethod();
                        System.out.println(url);
                    }
                }
            }
        }
    }

}
