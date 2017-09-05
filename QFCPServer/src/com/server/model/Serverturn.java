package com.server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.*;
import com.common.Message;
import com.common.User;

public class Serverturn {
	ServerSocket ss=null;
	public Serverturn()
	{
			try {
				System.out.println("启动监听...");
				ss=new ServerSocket(9999);
				ObjectOutputStream oos=null;
				Message msg=null;
				User user=null;
				ObjectInputStream ois=null;
				while(true)
				{
				Socket s=ss.accept();
				ois=new ObjectInputStream(s.getInputStream());
				user=(User)ois.readObject();
				
				
				
				
				
				if(user.getUser_pwd().equals("123456"))
				{
					oos=new ObjectOutputStream(s.getOutputStream());
					msg=new Message();
					msg.setMsg_type("1");
					//System.out.println(msg.getMsg_type());
					oos.writeObject(msg);
					SerconClieThread sct=new SerconClieThread(s);
					sct.start();
					//客户端启动线程
					ManageClientThread.addClientThread(user.getUser_id(), sct);
				}else{
					oos=new ObjectOutputStream(s.getOutputStream());
					msg=new Message();
					msg.setMsg_type("2");
					//System.out.println(msg.getMsg_type());
					oos.writeObject(msg);
					s.close();
					
				}
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}
}
