package com.ztest.boot.mvc.common.cache.config;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/13 0013 38
 */
@Deprecated
public class ConfigSelector extends AdviceModeImportSelector<EnableCache> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        return new String[]{CacheConfiguration.class.getName()};
    }
}
