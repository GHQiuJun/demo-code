package demo.database.mybatis.dao;

import demo.database.mybatis.entity.User;

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
    int updateUser(User user);
}
