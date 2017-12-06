package com.springtest.chapter1.config;

import com.springtest.chapter1.CompactDisc;
import com.springtest.chapter1.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 14:37
 * @version v1.00
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }
}
