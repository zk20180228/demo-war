package cn.ctcc.module.user2.service.impl;

import cn.ctcc.base.BaseServiceImpl;
import cn.ctcc.module.user2.bean.User2;
import cn.ctcc.module.user2.mapper.User2Mapper;
import cn.ctcc.module.user2.service.User2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 14:31
 * @Description:用户Service层,我们在service层使用缓存，需要注意的是当一个支持缓存的方法在对象内部被调用时是不会触发缓存功能的。
 */
@Service
public class User2ServiceImpl extends BaseServiceImpl<User2> implements User2Service {

    @Resource
    private User2Mapper user2Mapper;



}