package demo.database.mybatis;

import demo.database.mybatis.dao.UserMapper;
import demo.database.mybatis.entity.User;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @program: BatchInsertTest
 * @description: 批量插入 Test
 * @author: 60007949
 * @create: 2022-10-08 10:33
 **/
@SpringBootTest
public class BatchInsertTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    void testBatchInsert() throws Exception {
        // 循环插入
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            userMapper.insertUser(user);
        }
        long end = System.currentTimeMillis();
        System.out.println("循环插入100000条数据耗时：---------------" + (start - end) + "---------------");

        userMapper.deleteAllUsers();

        // Mybatis batch模式
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);//跟上述sql区别
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            userMapper.insertUser(user);
        }
        sqlSession.commit();
        long end1 = System.currentTimeMillis();
        System.out.println("Mybatis batch模式插入100000条数据耗时：---------------" + (start1 - end1) + "---------------");
        userMapper.deleteAllUsers();

        // Mybatis batch模式 批量
        int batchSize = 10000;
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            userMapper.insertUser(user);
            if (i >= 1 && i % batchSize == 0) {
                sqlSession.commit();
            }
        }
        sqlSession.commit();
        long end3 = System.currentTimeMillis();
        System.out.println("Mybatis batch模式批量插入100000条数据耗时：---------------" + (start3 - end3) + "---------------");
        userMapper.deleteAllUsers();

        // 批量foreach插入 注意sql长度限制，默认4Mb字符
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            userMapper.insertUser(user);
            if (i >= 1 && i % batchSize == 0) {
                sqlSession.commit();
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("foreach循环插入100000条数据耗时：---------------" + (start2 - end2) + "---------------");

        userMapper.deleteAllUsers();
    }

    @Test
    void testMybatisPlusInsertBatch(){
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);//跟上述sql区别
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            userMapper.insertUser(user);
        }
        sqlSession.commit();
        long end1 = System.currentTimeMillis();
        System.out.println("Mybatis batch模式插入100000条数据耗时：---------------" + (start1 - end1) + "---------------");
        userMapper.deleteAllUsers();
    }
}
