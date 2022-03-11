package demo.expandpoint;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author junqiu
 */
public class ExpandPoint implements InitializingBean {
    private String name = "property";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init(){
        System.out.println("调用init method");
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println("调用afterPropertiesSet修改属性值");
    }

    @Override
    public String toString() {
        return "ExpandPoint{" +
                "name='" + name + '\'' +
                '}';
    }
}
