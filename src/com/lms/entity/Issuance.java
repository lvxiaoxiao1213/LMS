package com.lms.entity;

import java.util.Date;

public class Issuance {
	private Integer issuanceId;
	private String userName;
	private String bookName;
	private Date issuanceDate;
	private Date returnDate;
	private Integer issuanStatus;
	public Issuance(){
		
	}
	
	public Issuance(Integer issuanceId, String userName,String bookName, Date issuanceDate, Date returnDate,Integer issuanStatus) {
		this.issuanStatus=issuanStatus;
		this.issuanceId = issuanceId;
		this.userName = userName;
		this.bookName = bookName;
		this.issuanceDate = issuanceDate;
		this.returnDate = returnDate;
	}
	
	public Integer getIssuanStatus() {
		return issuanStatus;
	}

	public void setIssuanStatus(Integer issuanStatus) {
		this.issuanStatus = issuanStatus;
	}

	public Integer getIssuanceId() {
		return issuanceId;
	}
	public void setIssuanceId(Integer issuanceId) {
		this.issuanceId = issuanceId;
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

	public Date getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(Date issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	
	
}
