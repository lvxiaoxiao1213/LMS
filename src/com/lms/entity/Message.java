package com.lms.entity;

import java.util.Date;

public class Message {
	private Integer messageId;
	private String messageContent;
	private String userName;
	private Date messageTime;
	private Integer ifread;
	
	public Message(){
		
	}
	public Message(Integer messageId,String messageContent,String userName,  Date messageTime, Integer ifread) {
		this.messageId = messageId;
		this.userName=userName;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
		this.ifread = ifread;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}
	public Integer getIfread() {
		return ifread;
	}
	public void setIfread(Integer ifread) {
		this.ifread = ifread;
	}
	
}
