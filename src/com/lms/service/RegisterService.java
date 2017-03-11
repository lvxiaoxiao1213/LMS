package com.lms.service;

import java.sql.SQLException;

import com.lms.dao.UserDao;
import com.lms.entity.User;

public class RegisterService {
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean register(User user){
		UserDao userDao=new UserDao();
		try {
			Integer userId=userDao.Insert(user);
			return userId!=null?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
