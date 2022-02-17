import demo.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: ApplicationContextTest
 * @description:
 * @author: 60007949
 * @create: 2022-02-07 18:11
 **/
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("IOC容器初始化完成");
        System.out.println(context.getBean("&parent"));
        System.out.println(context.getBean("parent"));
    }
}
