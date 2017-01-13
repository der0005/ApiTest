package com.daniel.resource.bundle;

public class User {
	private int id;
	private String userName;
	private String password;
	private String clearance;
	
	public User(){
		
	}
	
	public User(int id, String userName, String password, String clearance){
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.clearance = clearance;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClearance() {
		return clearance;
	}
	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

}
