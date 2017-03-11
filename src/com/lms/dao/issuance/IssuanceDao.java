package com.lms.dao.issuance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.Issuance;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class IssuanceDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	/**
	 * 遍历借书记录
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Issuance> findAll() throws SQLException {
		List<Issuance> issuances = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select IssuanceID,name,bookName,IssuanDate,ReturnDate,IssuanStatus from Issuance join Book on Issuance.bookId=Book.bookId join User on Issuance.id=User.id;";
		resultSet = statement.executeQuery(sql);

		Issuance issuance;
		while (resultSet.next()) {
			issuance = new Issuance(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getDate(4), resultSet.getDate(5),resultSet.getInt(6));
			issuances.add(issuance);
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return issuances;
	}
	/**
	 * 插入借书记录
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public Integer insert(Integer bookId,Integer id)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		String sql="insert into Issuance(id,bookId,IssuanDate)values(?,?,?)";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setInt(2, bookId);
		preparedStatement.setDate(3,new java.sql.Date(new java.util.Date().getTime()));
		Integer insert=preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return insert;
	}
	/**
	 * 归还书，将还书时间插入表，再将状态改为已归还
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer returnBook(Integer id)throws SQLException{
		connection = (Connection) DbUtil.getConn();
		String sql = "update Issuance set returnDate=?,IssuanStatus=? where IssuanceID=?";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
		preparedStatement.setInt(2, 1);
		preparedStatement.setInt(3, id);
		Integer update = preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return update;
	}
}
