package demo.entity;

/**
 * @program: Person
 * @description: 测试类Person
 * @author: 60007949
 * @create: 2022-01-30 14:49
 **/
public class Person {

    public Person() {
        System.out.println("调用Person无参构造函数");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("调用Person构造函数");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person : name = " + name;
    }

    public String toString1() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
