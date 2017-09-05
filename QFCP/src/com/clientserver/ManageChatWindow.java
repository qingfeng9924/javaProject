package com.clientserver;
import java.util.*;
import com.view.ChatWindow;
public class ManageChatWindow {

	static HashMap hm=new <String,ChatWindow>HashMap();
	public static void addChatWindow(String chatid,ChatWindow cw)
	{
		hm.put(chatid,cw);
	}
	public static ChatWindow getChatWindow(String chatid)
	{
		return (ChatWindow) hm.get(chatid);
	}
}
