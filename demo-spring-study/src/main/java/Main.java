import demo.entity.BeanConfig;
import demo.entity.Teacher;
import demo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: Main
 * @description: MainClass
 * @author: 60007949
 * @create: 2022-01-14 15:00
 **/
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        final User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(applicationContext1.getBean("teacher", Teacher.class));

    }
}
