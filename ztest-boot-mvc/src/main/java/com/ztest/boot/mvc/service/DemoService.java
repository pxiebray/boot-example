package com.ztest.boot.mvc.service;

import com.ztest.boot.mvc.common.Cached;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/12/19 0019 02
 */
@Cached
public interface DemoService {

    @Cached("demo")
    void getName(String id);
}
