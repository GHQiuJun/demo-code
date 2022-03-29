package demo.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: SpringJdbcTransactionIoc
 * @description: 使用注解使用jdbc事务
 * @author: 60007949
 * @create: 2022-03-15 17:12
 **/
public class SpringJdbcTransactionIoc {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
   public void test() {
        jdbcTemplate.update("update user set age = age + 1 where id=2");
        methodB();
    }

    @Transactional
    void methodB() {
        jdbcTemplate.update("update user set age = age + 1 where id=2");
        if (Boolean.TRUE) {
            throw new RuntimeException("methodB 抛出异常回滚");
        }
    }
}
