package demo.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: TestAware
 * @description: aware接口验证类
 * @author: 60007949
 * @create: 2022-03-14 10:47
 **/
public class TestAware implements BeanNameAware, ApplicationContextAware {

    public ApplicationContext applicationContext;

    public String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
