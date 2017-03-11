package com.lms.entity;

public class User {
	
      private Integer id;
      private String name;
      private String tell;
      private String idcard;
      private String address;
      private String email;
      private String password;
      private Integer role;
      private Integer status;
      private Integer lendNumber;
      
      
	
	public User() {
	}
	
	public User(Integer id,String tell, String address, String email) {
		this.id=id;
		this.tell = tell;
		this.address = address;
		this.email = email;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	 public User( String name,String tell,  String idcard, String address, String email, String password) {
			
			
			this.name = name;
			this.tell = tell;
			this.idcard = idcard;
			this.address = address;
			this.email = email;
			this.password = password;
		}

	  public User(Integer id, String name, String tell, String idcard, String address, String email, String password,
			Integer role, Integer status,Integer lendNumber) {
		
		this.id = id;
		this.name = name;
		this.tell = tell;
		this.idcard = idcard;
		this.address = address;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
		this.lendNumber = lendNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	 public Integer getLendNumber() {
			return lendNumber;
		}

		public void setLendNumber(Integer lendNumber) {
			this.lendNumber = lendNumber;
		}
	
}
