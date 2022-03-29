package demo.scope;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @program: Scope1
 * @description: 测试Bean
 * @author: 60007949
 * @create: 2022-03-08 17:38
 **/
public class Scope1 {

    @Autowired
    private Scope2 scope2;

    public Scope2 getScope2() {
        return scope2;
    }

    public void setScope2(Scope2 scope2) {
        this.scope2 = scope2;
    }
}
