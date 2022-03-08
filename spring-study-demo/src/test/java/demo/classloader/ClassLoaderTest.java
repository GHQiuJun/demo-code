package demo.classloader;

import org.junit.jupiter.api.Test;

import java.util.Set;

class ClassLoaderTest {

    @Test
    void printPath() {
        System.out.println("java.class.path: " + System.getProperty("java.class.path"));
        System.out.println("sun.boot.library.path: " + System.getProperty("sun.boot.library.path"));
        Set<Object> objects = System.getProperties().keySet();
        for (Object key : objects) {
            String keyStr = (String) key;
            System.out.println(keyStr + " :" + System.getProperty(keyStr));
        }
    }

    @Test
    void useClassLoader() {
        // app classloader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // ext classloader
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        // boot class loader
        ClassLoader bootClassLoader = classLoaderParent.getParent();
        System.out.println(bootClassLoader);
        ClassLoader parent = bootClassLoader.getParent();
        System.out.println(parent);
    }
}