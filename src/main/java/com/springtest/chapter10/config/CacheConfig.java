package com.springtest.chapter10.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/5 10:26
 * @version v1.00
 */
@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public EhCacheCacheManager cacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean = new EhCacheManagerFactoryBean();
        Resource res = new ClassPathResource("ehcache.xml");
        ehCacheFactoryBean.setConfigLocation(res);
        return ehCacheFactoryBean;
    }
}
