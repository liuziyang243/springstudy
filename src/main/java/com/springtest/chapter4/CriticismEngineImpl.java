package com.springtest.chapter4;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/6 16:04
 * @version v1.00
 */
public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {
    }

    @Override
    public String getCriticism() {
        return "This performance is awesome.";
    }
}
