package cn.ctcc.exception;


import cn.ctcc.util.BackResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 15:35
 * @Description: 整个系统的全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * 拦截指定的异常，包括try..catch中抛出的的异常对象(我们常常需要对异常包装，抛出自己定义的异常)
     * 发生异常时,返回json类型的数据
     * @param e
     * @return
     */
   @ExceptionHandler({RuntimeException.class})
   @ResponseBody
   public BackResult runtimeExceptionMessage(RuntimeException e){

       e.printStackTrace();
       log.error(e.getMessage());
       return BackResult.build(500,e.getMessage());
   }

    /**
     * Exception异常，当runtimeExceptionMessage没捕捉到的异常都会进入这个，跳转到错误页面，你可以选择把错误信息带到错误页面
     */
   @ExceptionHandler({Exception.class})
   @ResponseStatus(HttpStatus.OK)
   public String toErrorUI(Exception e, HttpServletRequest request){

       log.error(e.getMessage());
       //request.setAttribute("msg",e.getMessage());
       return "error/error";
   }





}
