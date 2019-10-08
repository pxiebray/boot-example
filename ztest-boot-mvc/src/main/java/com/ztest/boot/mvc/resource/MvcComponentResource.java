package com.ztest.boot.mvc.resource;

import com.ztest.boot.mvc.entity.MvcComponents;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/12/7 0007 50
 */
@RestController
public class MvcComponentResource {

    @Autowired
    private ApplicationContext context;

    @Autowired(required = false)
    private LocaleResolver localeResolver;

    @Autowired(required = false)
    private ThemeResolver themeResolver;

    @Autowired(required = false)
    private MultipartResolver multipartResolver;

    @Autowired(required = false)
    private ViewResolver viewResolver;

    @Autowired(required = false)
    private List<HttpMessageConverter<?>> httpMessageConverters;

    @Autowired(required = false)
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Autowired(required =  false)
    private List<HandlerInterceptor> interceptor;

    @RequestMapping("/mvc/configs")
    public MvcComponents getConfigs() {
        MvcComponents components = new MvcComponents();
        return components;
    }

}
