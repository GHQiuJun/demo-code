package demo.database.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: ClassRoom
 * @description: 教室实体
 * @author: 60007949
 * @create: 2022-01-05 14:43
 **/
@Data
public class ClassRoom implements Serializable {
    private Long id;
    private String name;
}
