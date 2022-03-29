package demo.customspringtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @program: SpringXmlTagNamespaceHandler
 * @description: NamespaceHandler
 * @author: 60007949
 * @create: 2022-03-29 18:00
 **/
public class SpringXmlTagNamespaceHandler  extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("springXmlTag", new SpringXmlTagBeanDefinitionParser());
    }
}
