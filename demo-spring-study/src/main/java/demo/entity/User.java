package demo.entity;

/**
 * @program: User
 * @description: 测试类User
 * @author: 60007949
 * @create: 2022-01-14 15:02
 **/
public class User {

    private User1 user1;

    private String name;

    private String age;

    private Teacher teacher;

    public User() {
    }

    public User(User1 user1, Teacher teacher) {
        this.user1 = user1;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setTeacher(User1 user1) {
        this.user1 = user1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user1=" + user1 +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
