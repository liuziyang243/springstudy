package com.springtest.chapter1.config;

import com.springtest.chapter1.BlankDisc;
import com.springtest.chapter1.CompactDisc;
import com.springtest.chapter1.SgtPeppers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 14:37
 * @version v1.00
 */
@Configuration
@PropertySource("classpath:configproperties.properties")
public class CDConfig {

    @Autowired
    Environment env;

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    @Qualifier("blankDisc")
    @Primary
    public BlankDisc disc() {
        return new BlankDisc(env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }
}
