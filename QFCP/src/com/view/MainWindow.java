package com.view;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.clientserver.ManageChatWindow;
public class MainWindow extends JFrame implements MouseListener{
	TopPanel tp=null;
	JToolBar jbr1=null;
	JButton jb_group=null;
	JButton jb_sigle=null;
	JPanel jp_friend=null;
	JScrollPane jsp=null;
	//∫√”—JLabel
	JLabel []jlb=new JLabel[30];
	static String reciver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainWindow();
	}
	public MainWindow()
	{
		this.setLayout(null);
		tp=new TopPanel();
		tp.setBounds(0, 0, 300, 100);
		jb_group=new JButton(new ImageIcon("image/Bump_group.JPG"));
		jb_sigle=new JButton(new ImageIcon("image/Bump_single.jpg"));
		jbr1=new JToolBar();
		jbr1.add(jb_group);
		jbr1.add(jb_sigle);
		jbr1.setBounds(0, 100, 300, 50);
		jp_friend=new JPanel();
		jp_friend.setLayout(new GridLayout(30,1,4,4));
		//jp_friend.setBounds(0, 150, width, height);
		for(int i=0;i<30;i++)
		{
			jlb[i]=new JLabel(""+i,new ImageIcon("image/Bump_single.jpg"),JLabel.LEFT);
			jp_friend.add(jlb[i]);
			jlb[i].addMouseListener(this);
			System.out.println(""+i);
		}
		jsp=new JScrollPane(jp_friend);
		jsp.setBounds(0, 150, 280, 400);
		jbr1.setFloatable(false);
		this.setTitle(LoginWindow.owner_id);
		System.out.println(LoginWindow.owner_id);
		this.add(jsp);
		this.setLocation(700, 50);
		this.add(jbr1);
		this.add(tp);
		this.setSize(300, 650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2)
		{
			String temp=((JLabel)e.getSource()).getText();
			ChatWindow cw=new ChatWindow();
//			Thread t=new Thread(cw);
//			t.start();
			reciver=temp;
			System.out.println(""+reciver);
			ManageChatWindow.addChatWindow(LoginWindow.owner_id+reciver, cw);
			System.out.println("ƒ„"+"∫Õ"+reciver+"¡ƒÃÏ");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		((JLabel)e.getSource()).setForeground(Color.BLUE);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		((JLabel)e.getSource()).setForeground(Color.black);
		
	}

}
class TopPanel extends JPanel
{
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	Image img_toppan=null;
	public TopPanel()
	{
		try {
			img_toppan=ImageIO.read(new File("image/Bump_toppanel.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(width,height);
		this.setVisible(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img_toppan, 0, 0, this.getWidth(),this.getHeight(),this);
		this.repaint();
	}
	
}
