package demo.scope;

import demo.conditional.BeanConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ScopeTestTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeBeanConfig.class);
    }

    @Test
   void testScope(){
        System.out.println(applicationContext.getBean(Scope2.class));
        System.out.println(applicationContext.getBean(Scope2.class));
        System.out.println(applicationContext.getBean(Scope1.class));
        System.out.println(applicationContext.getBean(Scope1.class));
    }
}