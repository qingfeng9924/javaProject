package com.server.model;
import java.net.*;

import com.common.Message;

import java.io.*;
public class SerconClieThread extends Thread{
	Socket s=null;
	public SerconClieThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{ 
		while(true)
	{
		try {
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message m=(Message) ois.readObject();
			System.out.println(m.getMsg_sender()+"对"+m.getMsg_reciver()+"说"+m.getMsg_con());
			//转发信息
			SerconClieThread sct=ManageClientThread.getClientThread(m.getMsg_reciver());
			ObjectOutputStream oos=new ObjectOutputStream(sct.s.getOutputStream());
			oos.writeObject(m);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

}
