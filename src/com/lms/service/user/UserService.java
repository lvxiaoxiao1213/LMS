package com.lms.service.user;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.UserDao;
import com.lms.entity.User;

public class UserService {

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	public String list() {
		UserDao dao=new UserDao();
		try {
			List<User> users=dao.findAll();
			if (users != null && users.size() > 0) {
				return JSON.toJSONString(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据name查找User
	 * @param name
	 * @return
	 */
	public User findUser(String name){
		UserDao dao=new UserDao();
		User user=null;
		try {			
			user = dao.findUser(name);
			if(user!=null)
				return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 删除用户信息
	 * 
	 * @param idStr
	 * @return
	 */
	public boolean delete(String idStr) {
		Integer id = Integer.valueOf(idStr);
		UserDao dao=new UserDao();
		try {
			return dao.delete(id) != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 升级用户
	 * @param idStr
	 * @return
	 */
	public boolean upgrade(String idStr){
		Integer id = Integer.valueOf(idStr);
		UserDao dao=new UserDao();
		try {
			return dao.roleUp(id) != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 降级用户
	 * @param idStr
	 * @return
	 */
	public boolean demotion(String idStr){
		Integer id = Integer.valueOf(idStr);
		UserDao dao=new UserDao();
		try {
			return dao.roleDown(id) != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 取消会员资格
	 * @param idStr
	 * @return
	 */
	public boolean disable(String idStr){
		Integer id=Integer.valueOf(idStr);
		UserDao dao=new UserDao();
		try {
			return dao.setStatus(id) !=0 ? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 恢复会员资格
	 * @param idStr
	 * @return
	 */
	public boolean enable(String idStr){
		Integer id=Integer.valueOf(idStr);
		UserDao dao=new UserDao();
		try {
			return dao.setStatusDown(id) !=0 ? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 修改User资料
	 * @param user
	 * @return
	 */
	public boolean update(User user){
		UserDao dao=new UserDao();
		try {
			return dao.update(user) != 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean updatePwd(String name,String password){
		UserDao dao=new UserDao();
		try {
			return dao.updatePwd(name, password)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据name查找ID
	 * @param bookName
	 * @return
	 */
	public int findId(String name){
		UserDao dao=new UserDao();
		int id=0;
		try {
			id=dao.findId(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}
