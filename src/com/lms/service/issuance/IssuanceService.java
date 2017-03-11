package com.lms.service.issuance;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.issuance.IssuanceDao;
import com.lms.entity.Issuance;

public class IssuanceService {
	/**
	 * 遍历借书详情
	 * 
	 * @return
	 */
	public String list() {
		IssuanceDao dao = new IssuanceDao();
		try {
			List<Issuance> issuances = dao.findAll();
			if (issuances != null && issuances.size() > 0) {
				return JSON.toJSONString(issuances);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 保存借书信息
	 * @param booId,id
	 * @return
	 */
	public boolean save(Integer bookId,Integer id) {
		IssuanceDao dao = new IssuanceDao();
		try {
			return dao.insert(bookId,id) != 0 ? true : false;
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 还书
	 * @param id
	 * @return
	 */
	public boolean returnBook(Integer id){
		IssuanceDao dao=new IssuanceDao();
		try {
			return dao.returnBook(id)!=0 ?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
