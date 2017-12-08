package com.springtest.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/8 11:19
 * @version v1.00
 */
@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {

    @Override
    @Cacheable(value = "cacheTest", key = "#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}
