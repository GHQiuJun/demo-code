package demo.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: ProxyInvocationHandler
 * @description: 动态代理处理器
 * @author: 60007949
 * @create: 2022-01-07 11:16
 **/
public class ProxyInvocationHandler implements InvocationHandler {
    /**
     * 操作对象
     */
    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理调用处理器 ");
        return method.invoke(target, args);
    }
}

