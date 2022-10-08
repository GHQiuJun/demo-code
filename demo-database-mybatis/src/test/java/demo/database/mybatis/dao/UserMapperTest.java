package demo.database.mybatis.dao;


import demo.database.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class UserMapperTest {

    @Test
    void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        SqlSession session1 = sqlSessionFactory.openSession(true);
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.selectUserById(1);

            // 一级缓存会话级别，默认开启，同一会话更新操作会让缓存失效，不同会话间缓存会造成脏读
            Object z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第一次查询" + z);

            // 使用缓存
            z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第二次查询" + z);

            User user = new User();
            user.setAge(200);
            user.setId(1L);
            z = session1.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session1第一次查询" + z);

            // session1执行更新操作，缓存更新
            session1.update("demo.database.mybatis.dao.UserMapper.updateUser", user);

            // session1缓存失效，不从缓存读取
            z = session1.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session1第二次查询" + z);

            // session1发生更新操作，不影响session缓存
            z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第三次查询" + z);
        } finally {
            session.close();
            session1.close();
        }
    }

    @Test
    void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(false);
        SqlSession session1 = sqlSessionFactory.openSession(true);
        try {
            // 二级缓存作用于mapper级别
            Object z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第一次查询" + z);

            z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第一次查询" + z);

            z = session1.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session1第一次查询" + z);
            session1.commit();

            z = session1.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session1第一次查询（走二级缓存）" + z);

            z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session应该走二级缓存" + z);

            User user = new User();
            user.setAge(1000);
            user.setId(1L);

            // session1执行更新操作，缓存更新
            session1.update("demo.database.mybatis.dao.UserMapper.updateUser", user);
            //session1.commit();

            z = session.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session第二次查询" + z);

            z = session1.selectOne("demo.database.mybatis.dao.UserMapper.selectUserById", 1);
            System.out.println("session1第二次查询" + z);
        } finally {
            session.close();
            session1.close();
        }
    }
}