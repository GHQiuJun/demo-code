package demo.beanconfig;

import demo.entity.ParentOther;
import demo.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @program: TestBeanConfig
 * @description: test bean config
 * @author: 60007949
 * @create: 2022-02-25 17:07
 **/
@Configuration
//@Component
/**
 * @Configuration full 模式
 * 调用Person构造函数
 * 模拟调用两次person()是否会生成两个不同对象
 * demo.entity.Person@3ad83a66
 * demo.entity.Person@3ad83a66
 * demo.entity.Person@3ad83a66
 *
 * lite 模式
 * 调用Person构造函数
 * 模拟调用两次person()是否会生成两个不同对象
 * 调用Person构造函数
 * demo.entity.Person@6283d8b8
 * 调用Person构造函数
 * demo.entity.Person@3b6ddd1d
 * demo.entity.Person@4f80542f
 */

public class TestBeanConfig {

    @Bean
    public Person person() {
        return new Person("TestBeanConfig");
    }

    @Bean
    public ParentOther parentOther() {
        System.out.println("模拟调用两次person()是否会生成两个不同对象");
        System.out.println(person().toString1());
        System.out.println(person().toString1());
        return new ParentOther();
    }
}


