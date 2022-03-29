package demo.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;


/**
 * @program: ScopeTest
 * @description: @Scope 测试类 BeanConfig
 * @author: 60007949
 * @create: 2022-03-08 17:34
 **/
@Configuration
public class ScopeBeanConfig {

    @Bean
    // @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Scope2 scope2() {
        return new Scope2();
    }

    @Bean
    // @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)  // 单例，生成代理类
    public Scope1 scope1(Scope2 scope2) {
        System.out.println("注入scope2:" + scope2);
        System.out.println("full 模式下调用scope2():" + scope2());
        System.out.println("full 模式下调用scope2():" + scope2());
        return new Scope1();
    }

    @Bean
    // 会话或请求作用域下，当单例依赖一个作用域为会话或请求的Bean时，单例会在IOC初始化过程中创建，而依赖的Bean在会话和请求时才会创建，如果不配置代理类，将会抛出NoSuchBeanDefinitionException
    //@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)  // 多例，生成代理类
    public Scope3 scope3() {
        return new Scope3();
    }
}
