package demo.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 60007949
 * @program: BeanConfig
 * @description: Bean配置类
 * ImportResource混合xml装配对象
 * @author: 60007949
 * @create: 2022-01-14 18:04
 **/
@Configuration
@ImportResource("spring-config.xml")
public class BeanConfig {

    @Bean(name = "teacher")
    public Teacher teacher() {
        return new Teacher();
    }
}
