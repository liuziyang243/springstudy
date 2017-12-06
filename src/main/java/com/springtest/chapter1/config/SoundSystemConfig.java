package com.springtest.chapter1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 14:39
 * @version v1.00
 */
@Configuration
@Import({CDConfig.class,
        CDPlayerConfig.class,
        ConditionConfig.class})
@ImportResource("classpath:chapterconfig.xml")
public class SoundSystemConfig {
}
