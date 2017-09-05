package com.clientserver;
import java.net.*;
import com.common.Message;
import com.view.ChatWindow;

import java.io.*;
public class ClientConServerThread implements Runnable{
	Socket s=null;
	public ClientConServerThread(Socket s)
	{
		this.s=s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			    Message m=(Message)ois.readObject();
			    
			    ChatWindow ct=(ChatWindow) ManageChatWindow.hm.get(m.getMsg_reciver()+m.getMsg_sender());
			    System.out.println(m.getMsg_sender()+"发送的内容是"+m.getMsg_con());
			    ct.showmessage(m.getMsg_con());
			    } catch (Exception e){
			    	// TODO Auto-generated catch block
			    	e.printStackTrace();
			    	}
			}
	}
	public Socket getS() {
		return s;
	}

}
