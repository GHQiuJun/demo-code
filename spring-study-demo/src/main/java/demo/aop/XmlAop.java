package demo.aop;

/**
 * @program: XmlAop
 * @description: xml aop
 * @author: 60007949
 * @create: 2022-03-25 16:27
 **/
public class XmlAop {
    public void before() {
        System.out.println("before ......");
    }

    public void after() {
        System.out.println("after ......");
    }

    public void afterThrowing() {
        System.out.println("after-throwing ......");
    }

    public void afterReturning() {
        System.out.println("after-returning ......");
    }

    public void around() {
        System.out.println("around ......");
    }
}
