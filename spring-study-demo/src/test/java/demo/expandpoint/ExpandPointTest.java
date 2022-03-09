package demo.expandpoint;

import demo.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ExpandPointTest {

    public String a= String.valueOf(1);

    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    void testBeanFactoryProcessor() {
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        Assertions.assertEquals(person.getName(),"TestFactoryPostProcessor");

        ExpandPoint pointTest = applicationContext.getBean(ExpandPoint.class);
        System.out.println(pointTest);

        Assertions.assertEquals(pointTest.getName(),"name_xml");
    }
}