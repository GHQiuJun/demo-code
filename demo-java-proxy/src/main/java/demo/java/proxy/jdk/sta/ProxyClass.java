package demo.java.proxy.jdk.sta;

import demo.java.proxy.jdk.Subject;

/**
 * @program: ProxyClass
 * @description: 静态代理类
 * @author: 60007949
 * @create: 2022-01-09 16:54
 **/
public class ProxyClass implements Subject {
    private Subject subject;

    public ProxyClass(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String sayHello() {
        return this.subject.sayHello();
    }
}
