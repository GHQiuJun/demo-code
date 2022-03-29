package demo.customspringtag;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringTagTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-tag-config.xml");
    }

    @Test
    void test() {
        final SpringXmlTag springXmlTag = applicationContext.getBean(SpringXmlTag.class);
        System.out.println(springXmlTag);
        Assertions.assertEquals("springXmlTag",springXmlTag.getName());
    }
}