package demo.customspringtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @program: SpringXmlTagBeanDefinitionParser
 * @description: spring xml tag解析类
 * @author: 60007949
 * @create: 2022-03-29 17:44
 **/
public class SpringXmlTagBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return SpringXmlTag.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        builder.addPropertyValue("name", name);
    }
}
