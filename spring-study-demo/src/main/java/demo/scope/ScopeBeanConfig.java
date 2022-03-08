package demo.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.Scanner;

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
    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 组件多例
    public Scope2 scope2() {
        return new Scope2();
    }

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)  // 组件代理
    public Scope1 scope1() {
        return new Scope1();
    }
}
