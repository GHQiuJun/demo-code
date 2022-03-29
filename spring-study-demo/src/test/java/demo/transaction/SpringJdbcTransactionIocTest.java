package demo.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class SpringJdbcTransactionIocTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-jdbc-config.xml");
    }

    @Test
    void test1() {
        /**
         * TODO:
         * org.springframework.transaction.config.TxNamespaceHandler 没有被加载导致事务不生效
         *
         * Spring自定义标签和spring.handlers的加载过程
         * https://blog.csdn.net/wabiaozia/article/details/78631259
         */
        final SpringJdbcTransactionIoc springJdbcTransactionIoc = applicationContext.getBean(SpringJdbcTransactionIoc.class);
        springJdbcTransactionIoc.test();
    }
}