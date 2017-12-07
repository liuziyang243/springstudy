package com.springtest.chapter4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/6 14:20
 * @version v1.00
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.springtest.chapter4")
@ImportResource("classpath:config4.xml")
public class AOPConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    @Qualifier("comedy")
    public ComedyPerformance comedyPerformance() {
        return new ComedyPerformance();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }

//    @Bean
//    public CriticAspect criticAspect(CriticismEngine engine) {
//        CriticAspect criticAspect = Aspects.aspectOf(CriticAspect.class);
//        criticAspect.setCriticismEngine(engine);
//        return criticAspect;
//    }
}
