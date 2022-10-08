package demo.database.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 60007949
 */
@SpringBootApplication
@MapperScan({"demo.database.mybatis.dao"})
public class DemoDatabaseMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDatabaseMybatisApplication.class, args);
    }

}
