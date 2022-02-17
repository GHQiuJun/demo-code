package demo.java.proxy.jdk;

import org.junit.jupiter.api.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

class JdkProxyTest {

    @Test
    void use() {
        Subject subject = new SubjectImpl();
        Subject instance = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new ProxyInvocationHandler(subject));
        instance.sayHello();
    }

    @Test
    void generateProxyClass() {
        writeClassToDisk("./$JdkProxy4.class", Subject.class);
    }

    /**
     * 生成代理对象
     *
     * @param path
     * @param cla
     */
    public static void writeClassToDisk(String path, Class cla) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$JdkProxy4", new Class[]{cla});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}