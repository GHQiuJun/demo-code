package demo.expandpoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 1、BeanFactoryPostProcessor 在 bean 实例化之前被调用
 * 2、BeanFactoryPostProcessor 修改BD原数据
 *
 * @author junqiu
 */
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("运行TestFactoryPostProcessor.postProcessBeanFactory");
        BeanDefinition personBd = beanFactory.getBeanDefinition("person");
        MutablePropertyValues propertyValues = personBd.getPropertyValues();
        String propertyName = "name";
        if (propertyValues.contains(propertyName)) {
            propertyValues.addPropertyValue(propertyName, "TestFactoryPostProcessor");
        }
    }
}
