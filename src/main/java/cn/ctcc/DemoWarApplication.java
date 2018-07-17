package cn.ctcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/**
 * @Auther: zhangkui
 * @Date: 2018/7/13 11:29
 * @Description:程序入口
 */
@ServletComponentScan
@SpringBootApplication
public class DemoWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWarApplication.class, args);
	}
}
