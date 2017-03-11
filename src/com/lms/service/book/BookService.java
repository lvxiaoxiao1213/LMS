package com.lms.service.book;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.lms.dao.book.BookDao;
import com.lms.entity.book.Book;

public class BookService {
	/**
	 * 保存图书
	 * @param book
	 * @return
	 */
	public boolean save(Book book) {
		BookDao dao = new BookDao();
		try {
			return dao.insert(book) != 0 ? true : false;
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除图书
	 * @param idStr
	 * @return
	 */
	public boolean delete(String idStr){
		Integer bookId = Integer.valueOf(idStr);
		BookDao dao=new BookDao();
		try {
			return dao.delete(bookId) != 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 遍历图书
	 * 
	 * @return
	 */
	public String list() {
		BookDao dao = new BookDao();
		try {
			List<Book> books = dao.findAll();
			if (books != null && books.size() > 0) {
				return JSON.toJSONString(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 根据bookName获取Book记录
	 * @param bookName
	 * @return
	 */
	public String query(String bookName){
		BookDao dao = new BookDao();
		try {
			List<Book> books =  dao.findOne(bookName);
			if (books != null && books.size() > 0) {
				return JSON.toJSONString(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据作者名查找书
	 * @param auth
	 * @return
	 */
	public String query2(String auth){
		BookDao dao=new BookDao();
		try {
			List<Book> books =  dao.findOne2(auth);
			if (books != null && books.size() > 0) {
				return JSON.toJSONString(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据ID查找book
	 * @param id
	 * @return
	 */
	public Book findBookById(Integer id){
		BookDao dao=new BookDao();
		Book book=null;
		try {
			book=dao.findBookById(id);
			if(book!=null)
				return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
		
	}
	/**
	 * 修改状态为已借出
	 * @param bookName
	 * @return
	 */
	public boolean statusUp(String bookName){
		BookDao dao=new BookDao();
		try {
			return dao.setStatus(bookName)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 修改状态为在库
	 * @param bookName
	 * @return
	 */
	public boolean statusDown(String bookName){
		BookDao dao=new BookDao();
		try {
			return dao.setStatusDown(bookName)!=0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据bookName查找ID
	 * @param bookName
	 * @return
	 */
	public int findId(String bookName){
		BookDao dao=new BookDao();
		int bookId=0;
		try {
			bookId=dao.findId(bookName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookId;
	}
}
