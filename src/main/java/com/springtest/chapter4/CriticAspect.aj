package com.springtest.chapter4;

/**
 * @author lzy
 *
 * Create Time: 2017/12/6 15:36
 * @version v1.00
 */
public aspect CriticAspect {
    private CriticismEngine criticismEngine;

    pointcut performance(): execution(* com.springtest.chapter4.Performance.perform(..));

    after() returning : performance(){
        System.out.println("----This is from aspectj---");
        System.out.println(criticismEngine.getCriticism());
        System.out.println("----This is from aspectj---");
    }

    public CriticAspect() {
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
