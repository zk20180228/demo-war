package cn.ctcc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description:自定义监听器
 * @Author: zhangkui
 * @CreateDate: 2018/7/13 13:58
 * @Modifier: zhangkui
 * @version: V1.0
 */
@WebListener
public class HelloListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("web上下文被创建!");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("web上下文被销毁！");
    }
}
