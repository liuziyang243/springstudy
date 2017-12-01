package com.springtest.chapter1.config;

import com.springtest.chapter1.MagicBean;
import com.springtest.chapter1.MagicExistsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 16:40
 * @version v1.00
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean getMagicBean() {
        return new MagicBean();
    }
}
