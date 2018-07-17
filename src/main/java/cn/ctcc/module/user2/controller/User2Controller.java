package cn.ctcc.module.user2.controller;

import cn.ctcc.base.BaseController;
import cn.ctcc.module.user2.bean.User2;
import cn.ctcc.module.user2.service.User2Service;
import cn.ctcc.util.BackResult;
import cn.ctcc.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 14:42
 * @Description: 这不是标准的demo,标准的demo是user1,这个demo只演示封装base层后，业务层和持久层的做法
 */
@Slf4j
@RestController
@RequestMapping("user2")
public class User2Controller extends BaseController {

    @Resource
    private User2Service userService;

    //添加单个对象
    @RequestMapping("insert")
    public BackResult insert()throws Exception{

        User2 user = new User2("测试","root", "13333432802", "13333432803@qq.com", new Date(), new Date());
        userService.insert(user);

        return BackResult.ok();
    }


    //查询单个对象
    @RequestMapping("select")
    public BackResult select(int id)throws Exception{

        User2 user = new User2();
        user.setId(id);
        user = userService.select(user);

        return BackResult.ok(user);
    }

    //分页查询
    @RequestMapping("selectListByPage")
    public BackResult selectListByPage()throws Exception{

        PageUtil<User2> page=new PageUtil<>();

        User2 user = new User2();
        user.setUsername("honry");
        page.setEntity(user);
        PageUtil<User2> rs = userService.selectListByPage(page);

        return BackResult.ok(rs);
    }



}
