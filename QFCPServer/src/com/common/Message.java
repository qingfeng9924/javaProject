package com.common;

public class Message implements java.io.Serializable {
	private String msg_type=null;
	private String msg_con=null;
	public String getMsg_con() {
		return msg_con;
	}

	public void setMsg_con(String msg_con) {
		this.msg_con = msg_con;
	}

	public String getMsg_sender() {
		return msg_sender;
	}

	public void setMsg_sender(String msg_sender) {
		this.msg_sender = msg_sender;
	}

	public String getMsg_reciver() {
		return msg_reciver;
	}

	public void setMsg_reciver(String msg_reciver) {
		this.msg_reciver = msg_reciver;
	}

	public String getMsg_time() {
		return msg_time;
	}

	public void setMsg_time(String msg_time) {
		this.msg_time = msg_time;
	}

	private String msg_sender=null;
	private String msg_reciver=null;
	private String msg_time=null;

	public String getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
}
