package com.ztest.framework.boot;

import com.ztest.framework.boot.web.ExceptionAdvice;
import com.ztest.framework.boot.web.ResponseAdvice;
import com.ztest.framework.boot.web.client.HttpRequestInterceptor;
import com.ztest.framework.boot.web.filter.RequestContextFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BaseAutoConfiguration {


	@ConditionalOnMissingBean(RestTemplate.class)
//	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new HttpRequestInterceptor());
		return restTemplate;
	}

	@Bean
	public ResponseAdvice responseAdvice() {
		return new ResponseAdvice();
	}

	@Bean
	public ExceptionAdvice exceptionAdvice() {
		return new ExceptionAdvice();
	}

	@Bean
	public RequestContextFilter requestContextFilter() {
		return new RequestContextFilter();
	}

}
