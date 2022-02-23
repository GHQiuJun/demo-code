package demo.conditional;


import demo.conditional.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BeanConfigTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
    }

    @Test
    void testNoConditional() {
        System.out.println(applicationContext.getBean(Dog.class));
        System.out.println(applicationContext.getBean(Cat.class));
        System.out.println("没有设置条件加载，Cat、Dog均被加载入容器");
    }

    @Test
    void testConditional() {
        System.out.println("系统环境变量为windows,getBean(Mac.class) 抛出NoSuchBeanDefinitionException异常");
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(Mac.class));

        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("os.name"));

        System.out.println(applicationContext.getBean(Windows.class));
    }

    @Test
    void testConditionalOnBean() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean(Test01.class));
    }
}