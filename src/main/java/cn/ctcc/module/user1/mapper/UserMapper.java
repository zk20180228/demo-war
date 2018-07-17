package cn.ctcc.module.user1.mapper;


import cn.ctcc.module.user1.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 14:31
 * @Description:用户持久层层
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户
     * @param id
     * @return user实体
     * @throws Exception Service层和Mapper层不要处理异常，都把异常抛给Controller,在Controller层统一处理
     */
    User findUserById(@Param("id") String id)throws Exception;

    /**
     * 添加用户
     * @param user
     * @return void
     * @throws Exception Service层和Mapper层不要处理异常，都把异常抛给Controller,在Controller层统一处理
     */
    void addUser(User user)throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @return void
     * @throws Exception Service层和Mapper层不要处理异常，都把异常抛给Controller,在Controller层统一处理
     */
    void delUserById(int id)throws Exception;

    /**
     * 根据id更新用户
     * @param user
     * @return void
     * @throws Exception Service层和Mapper层不要处理异常，都把异常抛给Controller,在Controller层统一处理
     */
    void updateUserByid(User user)throws Exception;



}
