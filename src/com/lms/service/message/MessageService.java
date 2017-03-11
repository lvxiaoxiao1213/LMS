package com.lms.service.message;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.message.MessageDao;
import com.lms.entity.Message;

public class MessageService {
	/**
	 * 遍历借书详情
	 * 
	 * @return
	 */
	public String list() {
		MessageDao dao = new MessageDao();
		try {
			List<Message> messages = dao.findAll();
			if (messages != null && messages.size() > 0) {
				return JSON.toJSONString(messages);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 用户查看消息标记已读
	 * @param id
	 * @return
	 */
	public boolean read(Integer id){
		MessageDao dao=new MessageDao();
		try {
			return dao.read(id)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查找未读消息数量
	 * @return
	 */
	public Integer query(Integer id){
		MessageDao dao=	new MessageDao();
		try {
			return dao.query(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
