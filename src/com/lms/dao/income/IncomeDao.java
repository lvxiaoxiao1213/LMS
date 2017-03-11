package com.lms.dao.income;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.Income;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class IncomeDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	/**
	 * 遍历收入列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Income> findAll() throws SQLException {
		List<Income> incomes = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select incomeId,name,incomeCat,money,incomeStatus from income join User on income.id=User.id";
		resultSet = statement.executeQuery(sql);

		Income income;
		while (resultSet.next()) {
			income = new Income(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
					resultSet.getInt(4),resultSet.getInt(5));
			incomes.add(income);
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return incomes;
	}
	/**
	 * 将付款状态改为已付款
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer setStatus(Integer id)throws SQLException{
		connection=(Connection)DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update income set incomeStatus=1 where incomeId="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
}
