package demo.conditional;

import demo.conditional.entity.Cat;
import demo.conditional.entity.Test01;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: BeanConfig1
 * @description: Bean记载配置类
 * @author: 60007949
 * @create: 2022-02-23 17:16
 **/
@Configuration
public class BeanConfig1 {
    /**
     * test01没有被加载
     * <p>
     * 原因：在解析BeanDefinition过程中，优先解析@Component，@Service，@Controller注解的类。其次解析配置类，也就是@Configuration标注的类。
     * Test01 和 Cat 在不同的Configuration中，不能保证谁会被优先解析
     *
     * @return
     */
    @Bean
    //@ConditionalOnClass(Cat.class)
    public Test01 test() {
        return new Test01();
    }

}
