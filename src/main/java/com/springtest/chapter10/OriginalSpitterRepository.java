package com.springtest.chapter10;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 15:53
 * @version v1.00
 */
public interface OriginalSpitterRepository {

    void addSpitter(Spitter spitter);

    Spitter findOne(long id);

    void remove(long id);
}
