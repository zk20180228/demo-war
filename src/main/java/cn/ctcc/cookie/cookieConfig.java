package cn.ctcc.cookie;
/*

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
*/

/**
 * @Description: 自定义JSESSIONID的名字,
 * 也即浏览器第一次访问服务器set-cookies的请求头的cookie值。在做session的集中管理的时候会用到
 * @Author: zhangkui
 * @CreateDate: 2018/7/13 13:58
 * @Modifier: zhangkui
 * @version: V1.0
 */
//@Configuration
/*public class cookieConfig {

    @Value("${spring.session.cookieName}")
    private String cookieName;


    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName(cookieName);//设置JSESSIONID名称
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

}*/
