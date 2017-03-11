package com.lms.dao.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.Message;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MessageDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	/**
	 * 遍历消息列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Message> findAll() throws SQLException {
		List<Message> messages = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select messageId,messageCatContent,name,receiveTime,ifRead from message join User on message.receiveId=User.id join messageCat on message.messageCatID=messageCat.messageCatId;";
		resultSet = statement.executeQuery(sql);

		Message message;
		while (resultSet.next()) {
			message = new Message(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getInt(5));
			messages.add(message);
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return messages;
	}
	/**
	 * 用户已读改变ifRead
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer read(Integer id)throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update message set ifRead=1 where messageId="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 获取未读消息数量
	 * @return
	 * @throws SQLException
	 */
	public Integer query(Integer id)throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement =(Statement)DbUtil.getStmt(connection);
		String sql="select count(*) from message where ifRead=0 and receiveId="+id;
		resultSet=statement.executeQuery(sql);
		int count=0;
		if (resultSet != null && resultSet.first()) {
			count=resultSet.getInt(1);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return count;
	}
	
}
