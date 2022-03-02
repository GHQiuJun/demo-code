package demo.spring.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties 说明 https://www.cnblogs.com/jimoer/p/11374229.html
 * car 配置
 * @author junqiu
 */
@ConfigurationProperties(prefix = "demo.car")
public class CarProperties {
    public static final String NAME ="BAO-MA";
    public static final String COLOR ="RED";

    private String name = NAME;

    private String color = COLOR;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
