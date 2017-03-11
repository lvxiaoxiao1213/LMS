package com.lms.service.income;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.income.IncomeDao;
import com.lms.entity.Income;

public class IncomeService {
	/**
	 * 遍历收入
	 * 
	 * @return
	 */
	public String list() {
		IncomeDao dao = new IncomeDao();
		try {
			List<Income> incomes = dao.findAll();
			if (incomes != null && incomes.size() > 0) {
				return JSON.toJSONString(incomes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 修改付款状态
	 * @param idStr
	 * @return
	 */
	public boolean setStatus(String idStr){
		Integer id = Integer.valueOf(idStr);
		IncomeDao dao=new IncomeDao();
		try {
			return dao.setStatus(id) != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
