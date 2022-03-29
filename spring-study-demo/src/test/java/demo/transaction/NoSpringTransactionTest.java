package demo.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class NoSpringTransactionTest {

    private NoSpringTransaction noSpringTransaction;

    @BeforeEach
    void before() {
        noSpringTransaction = new NoSpringTransaction();
    }

    @Test
    void methodA() throws SQLException {
        noSpringTransaction.methodA();
    }

    @Test
    void getConnection() {
    }
}