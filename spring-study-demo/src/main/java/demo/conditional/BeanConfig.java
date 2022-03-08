package demo.conditional;

import demo.conditional.entity.*;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.*;

/**
 * @program: BeanConfig
 * @description: 验证Conditional BeanConfig
 * @author: 60007949
 * @create: 2022-02-23 14:53
 **/
@Configuration
@Scope
public class BeanConfig {
    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Conditional(WindowsConditional.class)
    @Bean
    public Windows windows() {
        return new Windows();
    }

    @Conditional(MacConditional.class)
    @Bean
    public Mac mac() {
        return new Mac();
    }
}
