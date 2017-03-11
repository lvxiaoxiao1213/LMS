package com.lms.entity.book;

public class Book {

    private Integer bookId;
    private String  bookName;
	private String auth;
	private String publisher;
	private Integer catId;	
	private Integer status;
	private String remark;
	
	
	public Book(){
		
	}
	
	
	
	
	public Book(String bookName, String auth, String publisher, Integer catId,String remark) {
		
		this.bookName = bookName;
		this.auth = auth;
		this.catId=catId;
		this.publisher = publisher;
		this.remark = remark;
	}




	public Book(Integer bookId, String bookName, String auth, String publisher,Integer catId, Integer status, String remark) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.auth = auth;
		this.publisher = publisher;
		this.catId=catId;
		this.status = status;
		this.remark = remark;
	}



	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
}
