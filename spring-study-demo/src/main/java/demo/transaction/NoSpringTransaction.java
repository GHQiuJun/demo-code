package demo.transaction;

import com.mysql.jdbc.Driver;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @program: NoSpringTransaction
 * @description: 不使用Spring事务我们如何实现事务
 * @author: 60007949
 * @create: 2022-03-14 16:18
 **/
public class NoSpringTransaction {
    private final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public void methodA() throws SQLException {
        // Connection conn = getConnection();
        Connection conn = getConnectionByDataSource();
        connectionThreadLocal.set(conn);
        conn.setAutoCommit(false);

        final Statement statement = conn.createStatement();

        printUserId1(statement);

        try {
            String updateSql = "update user set name=77 where id=1";
            statement.execute(updateSql);

            printUserId1(statement);

            // methodB中无事务
            methodB();

            // methodC 中存在事务，我们可以采用传入conn的方式
            // 通过传入会话的方式，我们可以实现事务的传播，但是十分麻烦，每次调用都需要传递conn这个参数，我们可以使用ThreadLocal的方式避免频繁的参数传递
            methodC(conn);

            // 通过ThreadLocal实现事务传递
            methodC1();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        }
    }

    private void printUserId1(Statement statement) throws SQLException {
        final ResultSet resultSet = statement.executeQuery("select * from user where id = 1");
        if (resultSet.next()) {
            System.out.println("select user id=1,name=" + resultSet.getString(2));
        }
    }

    public void methodB() throws SQLException {
    }

    public void methodC(Connection connection) throws SQLException {

    }

    public void methodC1() throws SQLException {
        // get conn from ThreadLocal
        final Connection connection = connectionThreadLocal.get();
    }

    /**
     * use DriverManager
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        // 通过DriverManger注册驱动，注意此时Driver是在com.mysql.jdbc包中
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
    }

    /**
     * use DataSource
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionByDataSource() throws SQLException {
        DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test?useSSL=false");
        return dataSource.getConnection("root","root");
    }
}
