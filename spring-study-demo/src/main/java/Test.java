import demo.entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @program: Test
 * @description: 测试类
 * @author: 60007949
 * @create: 2022-01-30 14:42
 **/
public class Test {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        Person person = (Person) bf.getBean("person");
        System.out.println(person);
    }
}
