package com.client;

import com.clientserver.ClientServer;

public class ClientBs implements java.io.Serializable{

	public boolean loginbs(Object o)
	{
		ClientServer cs=new ClientServer();
		return cs.loginsqlserver(o);
	}
}
