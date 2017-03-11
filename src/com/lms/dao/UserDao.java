package com.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.User;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	/**
	 * 根据用户名和密码查找User
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public User findOne(String name, String password) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from User where name='" + name + "' and password='" + password + "'";
		resultSet = statement.executeQuery(sql);
		User user = null;
		if (resultSet != null && resultSet.first()) {
			user = new User(resultSet.getString(2), resultSet.getString(7));
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return user;
	}
	/**
	 * 根据用户名查看User
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public User findUser(String name)throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement =(Statement)DbUtil.getStmt(connection);
		String sql="select * from User where name='"+ name+"'";
		resultSet=statement.executeQuery(sql);
		User user=null;
		if(resultSet!=null&&resultSet.first()){
			user=new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
					resultSet.getInt(9), resultSet.getInt(10));
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return user;
	}
	/**
	 *根据用户名查找role值ֵ
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int findRole(String name)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		statement=(Statement) DbUtil.getStmt(connection);
		String sql="select * from User where name='"+name+"'";
		resultSet=statement.executeQuery(sql);
		int role=1;
		if (resultSet != null && resultSet.first()) {
			role=resultSet.getInt(8);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return role;
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public Integer Insert(User user)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		String sql="insert into User(name,tell,idcard,address,email,password) values(?,?,?,?,?,?)";
		preparedStatement=(PreparedStatement) DbUtil.getPstmt(connection, sql,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getTell());
		preparedStatement.setString(3, user.getIdcard());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getEmail());
		preparedStatement.setString(6, user.getPassword());

		
		preparedStatement.executeUpdate();
		resultSet = preparedStatement.getGeneratedKeys();
		Integer result = null;
		if (resultSet.next()) {
			result = resultSet.getInt(1);
		}
		DbUtil.closeConnPstatRs(connection, preparedStatement, resultSet);
		return result;
	}
	/**
	 * 根据身份证号查找用户
	 * 
	 * @param idcard
	 * @return
	 * @throws SQLException
	 */
	public User findOne(String idcard) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from user where idcard='" + idcard + "'";
		resultSet = statement.executeQuery(sql);
		User user = null;
		if (resultSet != null && resultSet.first()) {
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
					resultSet.getInt(9), resultSet.getInt(10));
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return user;
	}

	/**
	 * 遍历用户列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<User> findAll() throws SQLException {
		List<User> users = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from User where role=1 or role=2";
		resultSet = statement.executeQuery(sql);

		User user;
		while (resultSet.next()) {
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
					resultSet.getInt(9), resultSet.getInt(10));
			users.add(user);
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return users;
	}
	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer delete(Integer id) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "delete from User where id=" + id;
		Integer delete = statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return delete;
	}
	/**
	 * 修改role值到VIP
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer roleUp(Integer id)throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update User set role=2 where id="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 修改role值到普通会员
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public 	Integer roleDown(Integer id)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update User set role=1 where id="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 修改status:0->1
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer setStatus(Integer id)throws SQLException{
		connection=(Connection)DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update User set status=1 where id="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;		
	}
	/**
	 * 修改status:1->0
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer setStatusDown(Integer id)throws SQLException{
		connection=(Connection)DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update User set status=0 where id="+id;
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 *根据用户名查找status值ֵ
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int findStatus(String name)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		statement=(Statement) DbUtil.getStmt(connection);
		String sql="select * from User where name='"+name+"'";
		resultSet=statement.executeQuery(sql);
		int status=0;
		if (resultSet != null && resultSet.first()) {
			status=resultSet.getInt(9);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		System.out.println(status);
		return status;
	}
	/**
	 * 修改
	 * 
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public Integer update(User user) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		String sql = "update User set email=?,address=?,tell=? where id=?";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getAddress());
		preparedStatement.setString(3, user.getTell());
		preparedStatement.setInt(4, user.getId());
		Integer update = preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 根据name修改User密码
	 * @param id
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Integer updatePwd(String name,String password)throws SQLException{
		connection = (Connection) DbUtil.getConn();
		String sql = "update User set password=? where name=?";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setString(1,password);
		preparedStatement.setString(2,name);
		Integer update = preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 *根据用户名查找id值ֵ
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int findId(String name)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		statement=(Statement) DbUtil.getStmt(connection);
		String sql="select * from User where name='"+name+"'";
		resultSet=statement.executeQuery(sql);
		int id=0;
		if (resultSet != null && resultSet.first()) {
			id=resultSet.getInt(1);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return id;
	}
}








