import demo.conditional.BeanConfig;
import demo.conditional.entity.Cat;
import demo.conditional.entity.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: Test1
 * @description: 测试类1
 * @author: 60007949
 * @create: 2022-02-24 11:30
 **/
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(applicationContext.getBean(Dog.class));
        System.out.println(applicationContext.getBean(Cat.class));
        System.out.println("没有设置条件加载，Cat、Dog均被加载入容器");
    }
}
