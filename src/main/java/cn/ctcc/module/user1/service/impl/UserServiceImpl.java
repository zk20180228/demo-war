package cn.ctcc.module.user1.service.impl;

import cn.ctcc.module.user1.bean.User;
import cn.ctcc.module.user1.mapper.UserMapper;
import cn.ctcc.module.user1.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 14:31
 * @Description:用户Service层,我们在service层使用缓存，需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的。
 */
@CacheConfig(cacheNames={"users"})//应用的缓存策略，和配置文件的缓存策略的name一致
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
     * 如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
     * @return
     */
    @Cacheable(key = "'user_'+#id")//key是缓存的标识。user的单引号必须加，否则会认为是对象，会报错。#引入参数。参数值相当于user_xxx
    @Override
    public User findUserById(String id)throws Exception {
        return userMapper.findUserById(id);
    }

    /**
     * 使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
     * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     * @param user
     * @return
     */
    @Transactional
    @CachePut(key = "'user_'+#user.getId()")//key是缓存的标识。user的单引号必须加，否则会认为是对象，会报错。#引入参数。参数值相当于user_xxx
    @Override
    public void addUser(User user)throws Exception {

        userMapper.addUser(user);
    }

    /**
     *  @CacheEvict是用来标注在需要清除缓存
     * @param id
     * @return
     */
    @Transactional
    @CacheEvict(key = "'user_'+#id")//key是缓存的标识。user的单引号必须加，否则会认为是对象，会报错。#引入参数。参数值相当于user_xxx
    @Override
    public void delUserById(int id)throws Exception {

        userMapper.delUserById(id);
    }

    @Transactional
    @CachePut(key = "'user_'+#user.getId()")
    @Override
    public void updateUserByid(User user)throws Exception {

        userMapper.updateUserByid(user);
    }
}
