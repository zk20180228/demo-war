package cn.ctcc.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: cors(跨域)支持，自定义一个类继承WebMvcConfigurerAdapter,添加可以被跨域调用的url和指定的ip
 * @Author: zhangkui
 * @CreateDate: 2018/7/13 15:26
 * @Modifier: zhangkui
 * @version: V1.0
 */
@Configuration
public class CorsUtils extends WebMvcConfigurerAdapter{


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //如果是本机，不识别当前自己机器的ip，如http://192.168.3.213:9000，但是识别localhost
        registry.addMapping("/cors/*")//请求路径
                .allowedOrigins("*"); //*代表所有机器，多个路径逗号分隔http://192.168.3.213:9000,http://192.168.3.213:9001
    }
}
