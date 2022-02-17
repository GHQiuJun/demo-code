import demo.entity.Parent;
import demo.entity.ParentOther;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @program: FactoryBeanTest
 * @description: FactoryBean Test
 * @author: 60007949
 * @create: 2022-02-08 15:01
 **/
public class FactoryBeanTest {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

        // 获取factoryBean本身
        System.out.println(bf.getBean("&parent"));

        // 获取factoryBean getObject()方法返回的对象
        System.out.println(bf.getBean("parent"));

        ParentOther parentOther = bf.getBean(ParentOther.class);
        System.out.println(parentOther);
    }
}
