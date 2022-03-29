package demo.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SpringJdbcTransactionTest {

    private SpringJdbcTransaction springJdbcTransaction;

    @BeforeEach
    void before() {

        springJdbcTransaction = new SpringJdbcTransaction();
    }

    @Test
    void test() {
        springJdbcTransaction.test();
    }
}