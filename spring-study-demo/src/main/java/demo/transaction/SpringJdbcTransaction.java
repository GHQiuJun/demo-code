package demo.transaction;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @program: SpringJdbcTransaction
 * @description: Spring jdbc transaction
 * @author: 60007949
 * @create: 2022-03-14 21:46
 **/
public class  SpringJdbcTransaction {
    DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    TransactionTemplate tx;

    SpringJdbcTransaction() {
        tx = new TransactionTemplate(new DataSourceTransactionManager(dataSource));
        // 事务传播模式：
        // PROPAGATION_REQUES_NEW 每次都会新开启一个事务，同时把外层事务挂起，当当前事务执行完毕，恢复上层事务的执行。如果外层没有事务，执行当前新开启的事务即可
        // PROPAGATION_REQUIRED Spring默认的传播机制，如果外层有事务，则当前事务加入到外层事务，一块提交，一块回滚。如果外层没有事务，新建一个事务执行
        /**
         *  在PROPAGATION_REQUIRED模式下，内层事务的sql和外层事务的sql会在外层事务结束时进行提交或回滚。如果内层事务抛出异常e，在内层事务结束时，
         *   spring会把事务标记为“rollback-only”。这时如果外层事务捕捉了异常e，那么外层事务方法还会继续执行代码，直到外层事务也结束时进行提交，spring发现事务已经被标记为“rollback-only”，
         *   抛出异常Transaction rolled back because it has been marked as rollback-only
         */
        tx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    }

    void test() {
        tx.execute(t -> {
            methodA();
            return 0;
        });
    }

    /**
     * 测试事务传播机制
     */
    void methodA() {
        jdbcTemplate.update("update user set age = age + 1 where id=1");
        try {
            methodB();
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }
    }

    /**
     * 测试事务传播机制
     */
    void methodB() {
        // jdbcTemplate.update("update user set age = age + 1 where id=1");
        tx.execute(t -> {
            jdbcTemplate.update("update user set age = age + 1 where id=2");
//            if (Boolean.TRUE) {
//                throw new RuntimeException("methodB 抛出异常回滚");
//            }
            return 0;
        });
    }

    void testConnect() {
        // 每次创建连接关闭连接
        DataSource dataSource1 = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
        JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource1);
        jdbcTemplate1.update("update user set name = 100 where id=1");
        jdbcTemplate1.update("update user set name = 100 where id=1");
    }
}
