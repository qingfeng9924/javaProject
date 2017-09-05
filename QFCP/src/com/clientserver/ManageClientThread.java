package com.clientserver;
import java.util.*;
public class ManageClientThread {
	static HashMap hm=new <String,ClientConServerThread>HashMap();
	public static void addClientConServerThread(String QFCPid,ClientConServerThread ccst)
	{
		hm.put(QFCPid, ccst);
	}
	public static ClientConServerThread getClientConServerThread(String owner_id) {
		// TODO Auto-generated method stub
		return (ClientConServerThread)hm.get(owner_id);
	}

}
