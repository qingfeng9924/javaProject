package com.common;

public class User implements java.io.Serializable {
	private String user_id=null;
	private String user_msg=null;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	private String user_pwd=null;
}
