package com.lms.dao.book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.Lists;
import com.lms.entity.book.Book;
import com.lms.util.DbUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BookDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	
	
	/**
	 * 插入图书
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public Integer insert(Book book)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		String sql="insert into Book(bookName,auth,publisher,catId,remark)values(?,?,?,?,?)";
		preparedStatement = (PreparedStatement) DbUtil.getPstmt(connection, sql);
		preparedStatement.setString(1, book.getBookName());
		preparedStatement.setString(2, book.getAuth());
		preparedStatement.setString(3, book.getPublisher());
		preparedStatement.setInt(4, book.getCatId());
		preparedStatement.setString(5, book.getRemark());
		Integer insert=preparedStatement.executeUpdate();
		DbUtil.closePstmt(preparedStatement);
		DbUtil.closeConn(connection);
		return insert;
	}
	/**
	 * 删除图书
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Integer delete(Integer bookId) throws SQLException {
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "delete from Book where bookId=" + bookId;
		Integer delete = statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return delete;
	}
	
	/**
	 * 遍历图书
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAll() throws SQLException {
		List<Book> books = Lists.newArrayList();

		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from Book";
		resultSet = statement.executeQuery(sql);

		Book book;
		while (resultSet.next()) {
			book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getInt(5),resultSet.getInt(6), resultSet.getString(7));
			books.add(book);
		}
		DbUtil.closeConnStatRs(connection,preparedStatement, resultSet);
		return books;
	}
	/**
	 * 通过bookName获取Book
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findOne(String bookName) throws SQLException {
		List<Book> books = Lists.newArrayList();
		
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from Book where bookName='"+bookName+"'";
		resultSet = statement.executeQuery(sql);

		Book book;
		while (resultSet.next()) {
			book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getInt(5),resultSet.getInt(6), resultSet.getString(7));
			books.add(book);
		}
		DbUtil.closeConnStatRs(connection,preparedStatement, resultSet);
		return books;
	}
	/**
	 * 根据作者名获取Book
	 * @param auth
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findOne2(String auth) throws SQLException {
		List<Book> books = Lists.newArrayList();
		
		connection = (Connection) DbUtil.getConn();
		statement = (Statement) DbUtil.getStmt(connection);
		String sql = "select * from Book where auth='"+auth+"'";
		resultSet = statement.executeQuery(sql);

		Book book;
		while (resultSet.next()) {
			book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getInt(5),resultSet.getInt(6), resultSet.getString(7));
			books.add(book);
		}
		DbUtil.closeConnStatRs(connection,statement, resultSet);
		return books;
	}
	/**
	 * 根据id查找book
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book findBookById(Integer id)throws SQLException{
		connection =(Connection) DbUtil.getConn();
		statement =(Statement)DbUtil.getStmt(connection);
		String sql="select * from Book where BookId="+id;
		resultSet=statement.executeQuery(sql);
		Book book=null;
		if(resultSet!=null&&resultSet.first()){
			book=new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getInt(5),resultSet.getInt(6), resultSet.getString(7));
		}
		DbUtil.closeConnStatRs(connection, preparedStatement, resultSet);
		return book;
	}
	/**
	 * 根据bookName修改状态
	 * @param bookName
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public Integer setStatus(String bookName) throws SQLException{
		connection=(Connection)DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update Book set status=1 where bookName='"+bookName+"'";
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 * 根据bookName修改状态
	 * @param bookName
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public Integer setStatusDown(String bookName) throws SQLException{
		connection=(Connection)DbUtil.getConn();
		statement=(Statement)DbUtil.getStmt(connection);
		String sql="update Book set status=0 where bookName='"+bookName+"'";
		Integer update=statement.executeUpdate(sql);
		DbUtil.closeStmt(statement);
		DbUtil.closeConn(connection);
		return update;
	}
	/**
	 *根据书名查找id值ֵ
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public int findId(String bookName)throws SQLException{
		connection=(Connection) DbUtil.getConn();
		statement=(Statement) DbUtil.getStmt(connection);
		String sql="select * from Book where bookName='"+bookName+"'";
		resultSet=statement.executeQuery(sql);
		int id=0;
		if (resultSet != null && resultSet.first()) {
			id=resultSet.getInt(1);
		}
		DbUtil.closeConnStatRs(connection, statement, resultSet);
		return id;
	}
}
