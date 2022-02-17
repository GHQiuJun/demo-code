import demo.ComponentConfig;
import demo.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import demo.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentConfig.class)
public class MainTest {

    @Autowired
    private ComponentClass componentClass;

    @Autowired
    private TestService testService;

    @Autowired
    private Teacher teacher;

    @Autowired
    private User1 user1;

    @Autowired
    private User user;

    @Test
    public void testXml() {
        // 加载失败，生成的IOC容器(ClassPathXmlApplicationContext)中没有teacher bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        final User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testJavaConfig() {
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(BeanConfig.class);
        final Teacher teacher = applicationContext1.getBean("teacher", Teacher.class);
        System.out.println(teacher);
    }

    @Test
    public void testComponent() {
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(ComponentConfig.class);
        final ComponentClass componentClass = applicationContext1.getBean("componentClass", ComponentClass.class);
        System.out.println(componentClass);
    }
}