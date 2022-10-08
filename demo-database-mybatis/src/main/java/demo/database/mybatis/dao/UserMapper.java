package demo.database.mybatis.dao;

import demo.database.mybatis.entity.User;;

import java.util.List;

/**
 * @program: UserMapper
 * @description: User Dao层
 * @author: 60007949
 * @create: 2021-12-31 16:44
 **/
public interface UserMapper {
    /**
     * 根据id查询User
     *
     * @param id
     * @return
     */
    User selectUserById(Integer id);

    /**
     * 更新user
     *
     * @param user
     * @return
     */
    void updateUser(User user);

    /**
     * 插入user
     *
     * @param user user
     * @return
     */
    void insertUser(User user);

    /**
     * 删除user表所有数据
     */
    void deleteAllUsers();

    /**
     * 批量插入
     *
     * @param users user集合
     */
    void insertBatch(List<User> users);
}
