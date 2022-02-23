package demo.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: MacConditional
 * @description: mac conditioanal实现类
 * @author: 60007949
 * @create: 2022-02-23 16:06
 **/
public class MacConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        return property != null && property.contains("mac");
    }
}
