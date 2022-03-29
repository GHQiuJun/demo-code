import demo.aop.XmlAopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: Main
 * @description: 测试类
 * @author: 60007949
 * @create: 2022-03-25 12:23
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-config.xml");
        final XmlAopService xmlAopService = applicationContext.getBean(XmlAopService.class);
        xmlAopService.print();
    }
}
