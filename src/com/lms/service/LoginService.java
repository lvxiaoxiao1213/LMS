package com.lms.service;

import java.sql.SQLException;

import com.lms.dao.UserDao;
import com.lms.entity.User;

public class LoginService {

	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean login(String name,String password){
		UserDao dao=new UserDao();
		try {
			User user=dao.findOne(name, password);
			return user!=null?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 登录时查找role值跳转页面
	 * @param name
	 * @return
	 */
	public int loginRole(String name){
		UserDao dao =new UserDao();
		int role=1;
		try {
			role = dao.findRole(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	/**
	 * 登录时查找status值判断是否黑名单
	 * @param name
	 * @return
	 */
	public int loginStatus(String name){
		UserDao dao =new UserDao();
		int status=0;
		try {
			status = dao.findStatus(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
