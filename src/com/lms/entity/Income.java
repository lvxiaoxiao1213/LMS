package com.lms.entity;

public class Income {
	private Integer incomeId;
	private String userName;
	private Integer incomeCat;
	private Integer money;
	private Integer incomeStatus;
	
	public Income(){
		
	}
	
	public Income(Integer incomeId, String userName, Integer incomeCat, Integer money,Integer incomeStatus) {
		this.incomeStatus=incomeStatus;
		this.incomeId = incomeId;
		this.userName = userName;
		this.incomeCat = incomeCat;
		this.money = money;
	}
	
	

	public Integer getIncomeStatus() {
		return incomeStatus;
	}

	public void setIncomeStatus(Integer incomeStatus) {
		this.incomeStatus = incomeStatus;
	}

	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getIncomeCat() {
		return incomeCat;
	}
	public void setIncomeCat(Integer incomeCat) {
		this.incomeCat = incomeCat;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	
}
