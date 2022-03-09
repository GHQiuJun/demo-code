package demo.expandpoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 1、在对象实例化之后调用
 *
 * @author junqiu
 */
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("运行TestBeanPostProcessor.postProcessBeforeInitialization");
        System.out.println(bean);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("运行TestBeanPostProcessor.postProcessAfterInitialization");
        System.out.println(bean);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
