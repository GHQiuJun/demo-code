package demo.beanconfig;

import demo.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestBeanConfigTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new AnnotationConfigApplicationContext(TestBeanConfig.class);
    }

    @Test
    void testBeanConfig() {
        System.out.println(applicationContext.getBean(Person.class).toString1());
    }
}