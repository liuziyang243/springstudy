package com.springtest.chapter1.config;

import com.springtest.chapter1.CDPlayer;
import com.springtest.chapter1.CompactDisc;
import com.springtest.chapter1.MediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 9:48
 * @version v1.00
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public MediaPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
