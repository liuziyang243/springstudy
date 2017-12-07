package com.springtest.chapter4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/6 14:36
 * @version v1.00
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.springtest.chapter4.Performance+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
