package com.ztest.boot.first.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/5 0005 58
 */
@Configuration
@RestControllerEndpoint(id = "test")
public class TestControllerEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(TestControllerEndpoint.class);

    @Autowired
    private Environment environment;

    @GetMapping("/info")
    public String info() {
        logger.info("spring boot log ");
        return environment.getProperty("server.port");
    }
}
