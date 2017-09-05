package com.server.model;
import java.util.*;

public class ManageClientThread {
	public static HashMap hm=new HashMap<String,SerconClieThread>();
	//向hm添加一个客户端通讯线程
	public static void addClientThread(String uid,SerconClieThread sct)
	{
		hm.put(uid, sct);
	}
	public static SerconClieThread getClientThread(String uid)
	{
		return (SerconClieThread)hm.get(uid);
	}

}
