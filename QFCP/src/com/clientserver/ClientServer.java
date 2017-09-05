package com.clientserver;
import java.io.IOException;
import java.net.*;
import com.common.*;
import com.view.LoginWindow;
import java.io.*;

public class ClientServer {
	public Socket s=null;
	public boolean loginsqlserver(Object o)
	{
		boolean b = false;
		try {
			s=new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			Message msg=(Message)ois.readObject();
			if(msg.getMsg_type().equals("1"))
			{
				b=true;
				ClientConServerThread ccst=new ClientConServerThread(s);
				Thread t=new Thread(ccst);
				t.start();
				ManageClientThread.hm.put(LoginWindow.owner_id, ccst);
			}else
			{
				s.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);
		return b;
	}
}
