package com.springtest.chapter4;

/**
 * @author lzy
 *
 * Create Time: 2017/12/7 8:44
 * @version v1.00
 */
public aspect JudgeAspect {
    // inject
    private CriticismEngine criticismEngine;

    public JudgeAspect() {
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
