package com.lms.service.request;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.request.RequestDao;
import com.lms.entity.Request;

public class RequestService {
	/**
	 * 遍历请求
	 * 
	 * @return
	 */
	public String list() {
		RequestDao dao = new RequestDao();
		try {
			List<Request> requests = dao.findAll();
			if (requests != null && requests.size() > 0) {
				return JSON.toJSONString(requests);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 将请求状态设为挂起
	 * @param id
	 * @return
	 */
	public boolean ignore(Integer id){
		RequestDao dao=new RequestDao();
		try {
			return dao.statusUpdate(id, 3)!= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 将请求状态设为拒绝
	 * @param id
	 * @return
	 */
	public boolean reject(Integer id){
		RequestDao dao=new RequestDao();
		try {
			return dao.statusUpdate(id, 2)!= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 将请求状态设为已批准
	 * @param id
	 * @return
	 */
	public boolean admit(Integer id){
		RequestDao dao=new RequestDao();
		try {
			return dao.statusUpdate(id, 1)!= 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 插入一条借书请求
	 * @param bookId
	 * @param id
	 * @return
	 */
	public boolean insert(Integer bookId,Integer id){
		RequestDao dao=new RequestDao();
		try {
			return dao.insert(bookId,id)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 插入一条续借请求
	 * @param bookId
	 * @param id
	 * @return
	 */
	public boolean insertRenew(Integer bookId,Integer id){
		RequestDao dao=new RequestDao();
		try {
			return dao.insertRenew(bookId,id)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查找未处理请求数量
	 * @return
	 */
	public Integer query(){
		RequestDao dao=	new RequestDao();
		try {
			return dao.query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
