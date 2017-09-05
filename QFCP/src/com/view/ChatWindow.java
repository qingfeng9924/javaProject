package com.view;
import javax.swing.*;
import java.io.*;
import com.common.Message;
import com.common.*;
import com.clientserver.*;
import java.awt.event.*;
public class ChatWindow extends JFrame implements ActionListener{
	JButton jb_send=null;
	JTextField jtf=null;
	JTextArea jta=null;
	Message m=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatWindow();
	}
	public ChatWindow()
	{
		this.setLayout(null);
		jb_send=new JButton("·¢ËÍ");
		jb_send.setBounds(240,160,70,30);
		jb_send.addActionListener(this);
		jtf=new JTextField();
		jtf.setBounds(0, 160, 200, 30);
		jta=new JTextArea();
		jta.setBounds(0, 0, 330, 150);
		this.add(jb_send);
		this.add(jtf);
		this.add(jta);
		this.setSize(330,230);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 100);
		this.setVisible(true);
	}
	public void showmessage(String con)
	{
		this.jta.append(con+"\r\n");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_send)
		{
			m=new Message();
			m.setMsg_sender(LoginWindow.owner_id);
			m.setMsg_reciver(MainWindow.reciver);
			m.setMsg_time(new java.util.Date().toString());
			m.setMsg_con(jtf.getText().trim());
			//m.setMsg_con(jtf.getText().trim());
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientThread.getClientConServerThread(LoginWindow.owner_id).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true)
//		{
//			try {
//				ObjectInputStream ois=new ObjectInputStream(ClientServer.s.getInputStream());
//				Message m=(Message)ois.readObject();
//				String info=m.getMsg_con();
//				jta.append(m.getMsg_sender()+"¶Ô"+m.getMsg_reciver()+"Ëµ"+info+"\r\n");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//	}
//	

}
