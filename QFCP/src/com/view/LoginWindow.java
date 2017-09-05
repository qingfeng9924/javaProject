package com.view;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.client.ClientBs;
import com.common.User;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;
public class LoginWindow extends JDialog implements ActionListener,MouseListener{
	JLabel jlb_label=null;
	JLabel jlb_close=null;
	JLabel jlb_id=null;
	JLabel jlb_passwd=null;
	JLabel jlb_loginh=null;
	//JLabel jlb_passwdr=null;
	JButton jb_login=null;
	JButton jb_register=null;
	JTextField jtf=null;
	JPasswordField jpf=null;
	LoginPanel lp=null;
	public static String owner_id=null;
	Font myfont=new Font("Î¢ÈíÑÅºÚ",Font.BOLD,20);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginWindow();
	}
	public LoginWindow()
	{
		lp=new LoginPanel();
		lp.setBounds(0, 0, 450, 193);
		lp.setLayout(null);
		//new Thread(lp).start();
		jlb_id=new JLabel("ÕË»§:");
		jlb_id.setBounds(100, 205, 30, 30);
		jtf=new JTextField();
		jtf.setBounds(130, 205, 200, 30);
		jlb_passwd=new JLabel("ÃÜÂë:");
		jlb_passwd.setBounds(100, 235, 30, 30);
		jpf=new JPasswordField();
		jpf.setBounds(130, 235, 200, 30);
		jb_login=new JButton("µÇ Â¼");
		jb_login.setBackground(Color.cyan);
		jb_login.setBounds(130, 270, 100, 30);
		jb_login.addActionListener(this);
		jb_register=new JButton("×¢ ²á");
		jb_register.setBackground(Color.cyan);
		jb_register.setBounds(230, 270, 100, 30);
		jlb_loginh=new JLabel(new ImageIcon("image/Bump_loginh.JPG"));
		jlb_loginh.setBounds(0, 200, 100, 100);
		jlb_close=new JLabel(new ImageIcon("image/Bump_close.jpg"));
		jlb_close.setBounds(425, 0, 25, 25);
		jlb_close.addMouseListener(this);
		jlb_label=new JLabel("@Çå·ç´úÂë");
		jlb_label.setFont(new Font("»ªÎÄÐÂÎº",Font.BOLD,20));
		jlb_label.setBounds(250, 320, 150, 30);
		lp.add(jlb_close);
		this.setLayout(null);
		this.add(lp);
		this.add(jlb_id);
		this.add(jlb_passwd);
		this.add(jtf);
		this.add(jpf);
		this.add(jb_login);
		this.add(jb_register);
		this.add(jlb_loginh);
		this.add(jlb_label);
		Color c=new Color(255,255,255);
		this.getContentPane().setBackground(c);
		this.setLocation(450, 200);
		this.setSize(450,350);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()).equals(jlb_close))
		{
			System.exit(0);
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
		if(((JLabel)e.getSource()).equals(jlb_close))
		{
			jlb_close.setIcon(new ImageIcon("image/Bump_closes.gif"));
			//jlb_close.updateUI();
		}
		//lp.repaint();
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()).equals(jlb_close))
		{
			jlb_close.setIcon(new ImageIcon("image/Bump_close.jpg"));
			//jlb_close.updateUI();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb_login)
		{
			this.owner_id=jtf.getText().trim(); 
			//System.out.println("OK");
			ClientBs ct=new ClientBs();
			User user=new User();
			user.setUser_id(jtf.getText().trim());
			user.setUser_pwd(new String(jpf.getPassword()));
			if(ct.loginbs(user))
			{
				this.dispose();
				new MainWindow();
			}else{
				JOptionPane.showConfirmDialog(this, "µÇÂ¼Ê§°Ü");
			}
		}
		
	}

}
class LoginPanel extends JPanel
{
	int x;
	int y;
	Vector vt=new <Meteor>Vector();;
	Image img=null;  
	Image img_meteor=null;
	Meteor mt=null;
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	public LoginPanel()
	{
		try {
			img=ImageIO.read(new File("image/Bump_login.jpg"));
			img_meteor=ImageIO.read(new File("image/Bump_meteor.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++)
		{
			mt=new Meteor(0,i*10);
			Thread t=new Thread(mt);
			t.start();
			vt.add(mt);
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("»ªÎÄÐÂÎº",Font.BOLD,50));
		g.drawString("QFCP", 100, 100);
		g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		g.drawString("%100Áã¾àÀë", 150, 150);
		//g.drawString("ËûËý", 200, 150);
		this.repaint();
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i=0;i<vt.size();i++)
		{
			Meteor temp=(Meteor) vt.get(i);
			if(temp.islive==true)
			{
			g.drawImage(img_meteor, temp.x, temp.y,20,5,this );
			//System.out.println(temp.x+"     "+temp.y);
			}
			if(temp.islive==false)
			{
				vt.remove(i);
				//System.out.println(vt.size());
			}
			if(vt.size()<180)
			{
				for(int j=0;j<20;j++)
				{
				Meteor mt1=new Meteor((int)(Math.random()*200),(int)(Math.random()*200));
				Thread t=new Thread(mt1);
				t.start();
				vt.add(mt1);
				//System.out.println(vt.size());
				}
		}
		this.repaint();
	}
	
}
class Meteor implements Runnable
{
	int x;
	int y;
	boolean islive=true;
	public Meteor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x+=7;y-=2;
			if(x>450||y<0)
			{
				this.islive=false;
			}
			if(this.islive==false)
			{
				break;
			}
		}
	}
}
}
