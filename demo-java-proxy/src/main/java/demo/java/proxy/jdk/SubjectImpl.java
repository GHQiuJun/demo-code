package demo.java.proxy.jdk;

/**
 * @program: SubjectImpl
 * @description: 代理接口实现类
 * @author: 60007949
 * @create: 2022-01-07 11:15
 **/
public class SubjectImpl implements Subject {
    @Override
    public String sayHello() {
        System.out.println(" Hello World");
        return "success";
    }
}