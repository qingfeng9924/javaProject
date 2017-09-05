package com.view;
import javax.swing.*;

import com.common.*;
import com.server.model.Serverturn;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class QServer extends JFrame implements ActionListener{
	JButton jb_listen=null;
	JButton jb_stopl=null;
	ServerSocket ss=null;
	Socket s=null;
	static int turn=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QServer();
	}
	public QServer()
	{
		this.setLayout(null);
		jb_listen=new JButton("Æô¶¯¼àÌý");
		jb_listen.setBounds(100, 0, 100, 30);
		jb_listen.addActionListener(this);
		jb_stopl=new JButton("Í£Ö¹¼àÌý");
		jb_stopl.setBounds(500, 0, 100, 30);
		jb_stopl.addActionListener(this);
		this.add(jb_stopl);
		this.add(jb_listen);
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300,100);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_listen)
		{
			new Serverturn();
		}
		if(e.getSource()==jb_stopl)
		{
			try {
				ss.close();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
	}

}
}
