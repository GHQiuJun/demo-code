package demo.database.mybatis.dao;

import demo.database.mybatis.entity.ClassRoom;

/**
 * @program: demo-database-mybaits
 * @description: 教室mapper
 * @author: 60007949
 * @create: 2022-01-05 14:47
 **/
public interface ClassRoomMapper {
    /**
     * 根据id查询User
     *
     * @param id
     * @return
     */
    ClassRoom selectClassRoomById(Integer id);
}
