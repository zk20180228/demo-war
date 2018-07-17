package cn.ctcc.util;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/16 16:22
 * @Description:用于分页的bean
 */
public class PageUtil<T>  implements Serializable{

	private static final long serialVersionUID = 337297181251071639L;
	//当前页,默认是1
	private int page=1;
	
	//页大小,默认是10
	private int rows=10;
	
	//总记录数
	private int tatalRecord;
	
	//总页数
	private int taotalPages;

	//结果列表
	private List<T> list;
	
	//查询条件Bean
	private T entity;
	
	//查询的起始行
	private int start;

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		
		this.rows = rows;
	}


	public void setTatalRecord(int tatalRecord) {

		this.tatalRecord = tatalRecord;
	}
	

	public void setList(List<T> list) {

		this.list = list;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public int getStart() {
		return (page-1)*rows;
	}

	public void setStart(int start) {
		//当前页-1乘以记录数就是查询的起始行
		this.start = start;
	}

	public int getTatalRecord() {
		return tatalRecord;
	}

	public List<T> getList() {
		return list;
	}

	public int getTaotalPages() {
		//总页数由rows,和tatalRecord而来
		if(tatalRecord%rows==0){
			this.taotalPages = tatalRecord/rows;
		}else{
			this.taotalPages = tatalRecord/rows+1;
		}

		return taotalPages;
	}


}
