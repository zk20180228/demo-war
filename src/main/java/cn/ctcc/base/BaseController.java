package cn.ctcc.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Controller
public class BaseController {
	
		//容器会自动创建并注入
		@Resource
		protected ServletContext application;
		
		
		

}
