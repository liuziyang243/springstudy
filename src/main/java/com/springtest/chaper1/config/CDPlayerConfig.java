package com.springtest.chaper1.config;

import com.springtest.chaper1.CDPlayer;
import com.springtest.chaper1.CompactDisc;
import com.springtest.chaper1.MediaPlayer;
import com.springtest.chaper1.SgtPeppers;
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
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}
