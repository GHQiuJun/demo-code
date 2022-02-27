package demo.database.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: User
 * @description: 用户实体
 * @author: 60007949
 * @create: 2021-12-31 16:42
 **/
@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}