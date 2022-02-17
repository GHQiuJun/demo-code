package demo.java.proxy.jdk;

import demo.java.proxy.jdk.sta.ProxyClass;
import org.junit.jupiter.api.Test;

import javax.security.auth.Subject;

import static org.junit.jupiter.api.Assertions.*;

class ProxyClassTest {

    @Test
    void sayHello() {
        SubjectImpl subject = new SubjectImpl();
        ProxyClass proxyClass = new ProxyClass(subject);
        proxyClass.sayHello();
    }
}