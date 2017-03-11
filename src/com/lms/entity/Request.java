package com.lms.entity;

import java.util.Date;

public class Request {
	private Integer requestId;
	private String userName;
	private Integer requestCatId;
	private String bookName;
	private Date requestTime;
	private Integer requestStatus;
	
	public Request(){
		
	}
	
	public Request(Integer requestId, String userName, Integer requestCatId,String bookName, Date requestTime, Integer requestStatus) {
		this.requestId = requestId;
		this.userName = userName;
		this.bookName=bookName;
		this.requestCatId = requestCatId;
		this.requestTime = requestTime;
		this.requestStatus = requestStatus;
	}

	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getRequestCatId() {
		return requestCatId;
	}

	public void setRequestCatId(Integer requestCatId) {
		this.requestCatId = requestCatId;
	}

	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public Integer getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}
	
}
