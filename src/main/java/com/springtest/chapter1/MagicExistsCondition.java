package com.springtest.chapter1;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 16:38
 * @version v1.00
 */
public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext ctxt, AnnotatedTypeMetadata metadata) {
        Environment env = ctxt.getEnvironment();
        return env.containsProperty("magic");
    }
}
