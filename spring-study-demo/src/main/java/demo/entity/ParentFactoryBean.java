package demo.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: Parent
 * @description: FactoryBean
 * @author: 60007949
 * @create: 2022-02-08 14:57
 **/
public class ParentFactoryBean implements FactoryBean<ParentOther> {
    @Override
    public ParentOther getObject() throws Exception {
        return new ParentOther();
    }

    @Override
    public Class<?> getObjectType() {
        return ParentOther.class;
    }
}
