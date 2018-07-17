package cn.ctcc.base;

import cn.ctcc.util.PageUtil;

import java.util.List;


public interface BaseMapper<T> {
	
	
		//添加单个对象
		int insert(T t)throws Exception;
		
		//修改单个对象
		void update(T t)throws Exception;
		
		//删除单个对象
		int delete(T t)throws Exception;
		
		//根据主键批量删除
		int deleteList(String[] ids)throws Exception;
		
		//查询单个对象
		T select(T t)throws Exception;
	
		//多条件查询，返回列表集合[动态sql]
		List<T> selectListByPage(PageUtil<T> page)throws Exception;
		
		//多条件查询，返回总记录数[动态sql]
		Integer selectTotalCount(PageUtil<T> page)throws Exception;
		

}
