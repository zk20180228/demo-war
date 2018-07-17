package cn.ctcc.module.user1.controller;

import cn.ctcc.module.user1.bean.User;
import cn.ctcc.module.user1.service.UserService;
import cn.ctcc.util.BackResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 14:42
 * @Description:用户控制器
 */
@Slf4j
@Api("用户模块")
@Controller
@RequestMapping("user")
public class UserController  {

    @Resource
    private UserService userService;

    @ApiOperation(value = "根据id查询用户",notes = "现在是测试swaggwer",httpMethod ="GET",produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id",value = "用户id",required = true,dataType = "Integer")
    })
    @RequestMapping(value = "findUserById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BackResult findUserById(@PathVariable("id") String id){//throws Exception{

        //测试自定义异常
        //throw  new Exception("测试全局异常,自定义异常消息！");

       User user= null;
        try {
            user = userService.findUserById(id);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return BackResult.build(400,"网络故障，请稍后重试!");
        }

       return BackResult.ok(user);
    }


    @ApiOperation(value = "添加用户",notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="username",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="password",value = "用户密码",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="phone",value = "用户电话号码",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="email",value = "用户邮箱",required = true,dataType = "String")
    })
    @RequestMapping("addUser")
    @ResponseBody
    public BackResult addUser(String username,String password,String phone,String email){

        try {
            User user = new User(null,username, password, phone, email, new Date(), new Date());
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return BackResult.build(400,"网络故障，请稍后重试!");
        }

        return  BackResult.ok();

    }

    @ApiOperation(value = "根据id删除用户",notes = "根据id删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path",name="id",value = "用户id",required = true,dataType = "Integer")
    })
    @RequestMapping("delUserById/{id}")
    @ResponseBody
    public BackResult delUserById(@PathVariable("id") int id){
        try {
            userService.delUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return BackResult.build(400,"网络故障，请稍后重试!");
        }

        return  BackResult.ok();
    }

    @ApiOperation(value = "更新用户",notes = "更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value = "用户",required = true,dataType = "Long"),
            @ApiImplicitParam(paramType = "query",name="username",value = "用户名",required = true,dataType = "String"),
    })
    @RequestMapping("updateUserByid")
    @ResponseBody
    public BackResult updateUserByid(Long id,String username){

        try {
            User user = new User(id,username, null, null, null, null, new Date());
            userService.updateUserByid(user);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return BackResult.build(400,"网络故障，请稍后重试!");
        }

        return  BackResult.ok();
    }

    @RequestMapping("toUserListUI")
    public String toUserListUI(HttpServletRequest request){

        request.setAttribute("h1","hello word!");

        return "user/userList";//注意，不要加/,linux下会出错
    }




}
