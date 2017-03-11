package com.lms.dao.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.Request;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class RequestDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	/**
	 * 遍历请求列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Request> findAll() throws SQLException {
		List<Request> requests = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select requestId,name,requestCatId,bookName,requestTime,requestStatus from request left join User on request.id=User.id left join Book on request.bookId=Book.bookId";
		resultSet = statement.executeQuery(sql);

		Request request;
		while (resultSet.next()) {
			request = new Request(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
					resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6));
			requests.add(request);
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return requests;
	}

	/**
	 * 修改请求状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public Integer statusUpdate(Integer id, Integer status) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "update request set requestStatus=" + status + " where requestId=" + id;
		Integer update = statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 插入一条借书请求
	 * @param bookId
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer insert(Integer bookId,Integer id)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		String sql="insert into request(id,requestCatId,bookId,requestTime)values(?,?,?,?)";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, 1);
		preparedStatement.setInt(3, bookId);
		preparedStatement.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
		Integer insert=preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return insert;
	}
	/**
	 * 插入一条续借请求
	 * @param bookId
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer insertRenew(Integer bookId,Integer id)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		String sql="insert into request(id,requestCatId,bookId,requestTime)values(?,?,?,?)";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, 2);
		preparedStatement.setInt(3, bookId);
		preparedStatement.setDate(4,new java.sql.Date(new java.util.Date().getTime()));
		Integer insert=preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return insert;
	}
	/**
	 * 获取未处理请求数量
	 * @return
	 * @throws SQLException
	 */
	public Integer query()throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement =(Statement)DbUtil.getStmt(connection);
		String sql="select count(*) from request where requestStatus=0";
		resultSet=statement.executeQuery(sql);
		int count=0;
		if (resultSet != null && resultSet.first()) {
			count=resultSet.getInt(1);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return count;
	}
}
