package demo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class TestAwareTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    void testAware() {
        final TestAware testAware = applicationContext.getBean(TestAware.class);
        Assertions.assertEquals("testAware",testAware.beanName);
        Assertions.assertEquals(applicationContext,testAware.applicationContext);
    }
}