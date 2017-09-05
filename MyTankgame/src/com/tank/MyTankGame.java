package com.tank;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//import java.io.*;

public class MyTankGame extends JFrame implements ActionListener {

	FPanel fp=null;
	MyPanel mp=null;
	JMenuBar jmb=null;
	JMenu jm=null;
	JMenuItem jmi=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTankGame mt=new MyTankGame();

	}
	public MyTankGame()
	{
		fp=new FPanel();
		/*mp=new MyPanel();
		this.addKeyListener(mp);
		Thread t=new Thread(mp);
		mp.setBackground(Color.black);
		t.start();
		*/
		jmb=new JMenuBar();
		jm=new JMenu("game");
		jmi=new JMenuItem("开始游戏");
		jmi.addActionListener(this);
		jmi.setActionCommand("start");
		jmb.add(jm);
		//jmb.setLayout(new FlowLayout(FlowLayout.LEFT));
		jm.add(jmi);
		fp.add(jmb);
		this.setJMenuBar(jmb);
		this.add(fp);
		this.setSize(500, 500);
		this.setLocation(700, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("start"))
		{
			this.remove(fp);
			mp=new MyPanel();
			Thread t=new Thread(mp);
			mp.setBackground(Color.black);
			t.start();
			this.add(mp);
			this.addKeyListener(mp);
			this.setSize(500, 500);
			this.setLocation(700, 200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
	}
		
	}
class FPanel extends JPanel 
{
	Image imagex=null;
	public FPanel()
	{
		imagex=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Bump_x.jpg"));
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(imagex, 0, 0, 500, 500, this);
		Font myfont=new Font("华文新魏",Font.BOLD,30);
		g.setColor(Color.black);
		g.setFont(myfont);
		g.drawString("Stage1", 0, 200);
		g.drawString("作者：", 0, 300);
		g.drawString("清风", 70, 300);
		g.drawString("版本：坦克大战6.0", 0, 400);
		//g.setXORMode(Color.blue);
		this.repaint();
	}
}
class Wall
{
	int x;
	int y;
	boolean islive=true;
	public Wall(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
}
//我的游戏面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的Tank
	MyTank mytank=null;
	Home home;
	//Wall wall=null;
	int etsize=4;
	int a=30;
	int b=30;
	boolean ismove=true;
	Vector<EnermyTank> etc=new Vector<EnermyTank>();
	Vector<Bomb> bb=new Vector<Bomb>();
	Vector<Wall> ww=new Vector<Wall>();
	//Vector<Bomb> aa=new Vector<Bomb>();
	//Vector<Bomb> etbb=new Vector<Bomb>();
	Vector<Shot> est=new Vector<>();
	Image image1=null;
	Image image2=null;
	Image image3=null;
	Image image5=null;
	Image image6u=null;
	Image image6l=null;
	Image image6r=null;
	Image image6d=null;
	Image imagewall=null;
	//Image image4=null;
	public MyPanel()
	{
		for(int i=100;i<500;i=i+30)
		{
			for(int j=100;j<400;j=j+30)
			{
				Wall w=new Wall(i,j);
				ww.add(w);
				System.out.println(ww.size());
			}
		}
		mytank=new MyTank(200,400);
		for(int i=0;i<etsize;i++)
		{
			
		   EnermyTank et=new EnermyTank(i*100,50);
		   Shot s=new Shot(et.x+10,et.y+30,et.direct);
		   home=new Home(250,460);
		   etc.add(et);	
		   est.add(s);
		   Thread t=new Thread(et);
		   t.start();
		   Thread t1=new Thread(s);
		   t1.start();
		}
		/*try {
			image1=ImageIO.read(new File("bump_1.gif"));
			image2=ImageIO.read(new File("bump_2.gif"));
			image3=ImageIO.read(new File("bump_3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_3.gif"));
		image5=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_5.gif"));
		image6u=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_6_U.jpg"));
		image6r=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_6_R.jpg"));
		image6d=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_6_D.jpg"));
		image6l=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_6_L .jpg"));
		imagewall=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bump_wall.png"));
		
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawLine(0, 0,500,0);
		g.drawLine(0, 500,500,500);
		g.drawLine(0, 0,0,500);
		g.drawLine(500, 0,500,500);
		/*g.setColor(Color.red);
		g.fill3DRect(mytank.getX(), mytank.getY(), 5, 30,false);
		g.fill3DRect(mytank.getX()+15, mytank.getY(), 5, 30,false);
		g.fill3DRect(mytank.getX()+5, mytank.getY()+5, 10, 20,false);
		g.setColor(Color.orange);
		g.fillOval(mytank.getX()+5, mytank.getY()+10, 10, 10);
		g.setColor(Color.red);
		g.drawLine(mytank.getX()+10, mytank.getY(),mytank.getX()+10 , mytank.getY()+10);
		*/
		for(int i=0;i<ww.size();i=i+1)
		{
		    Wall  temp=ww.get(i);
			g.drawImage(imagewall, temp.x, temp.y, 30, 30, this);
			
		}
		if(mytank.islive==true)
		{
		this.drawMyTank(mytank.x,mytank. y, g, mytank.direct);
		}else
		{
			System.out.println("game over");
		}
		if(home.islive==true)
		{
			g.drawImage(image5, 250, 460, 40, 40, this);
		}
		//爆炸效果
		for(int i=0;i<bb.size();i++)
		{
			Bomb b=bb.get(i);
			if(b.time>4)
			{
				g.drawImage(image1, b.x-10, b.y, 10, 10, this);
			}
			else if(b.time>3&&b.time<5)
			{
				g.drawImage(image2, b.x-10, b.y, 15, 15, this);
			}
			else if(b.time>0&&b.time<4)
			{
				g.drawImage(image3, b.x-10, b.y, 20, 20, this);
			}
			else if(b.time==0)
			{
				for(int j=0;j<bb.size();j++)
				{
				bb.remove(j);
				}
			}
			b.lifeDown();
				
		}
		for(int i=0;i<etc.size();i++)
		{
			EnermyTank et=etc.get(i);
			if(et.islive==true)
			{
			this.drawEnermyTank(et.x, et.y, g, et.direct);
			}
			else
			{
				
				etc.remove(i);
				//this.drawTank(et.x, et.y, g, 3,0);
			}
		}
		for(int i=0;i<est.size();i++)
		{
			Shot s=est.get(i);
			if(s.islive)
			{
				g.setColor(Color.yellow);
				//g.drawLine(s.x, s.y, s.x+1, s.y+1);
				g.fillOval(s.x, s.y, 4, 4);
			}
				else if(s.islive==false)
				{
						Bomb b=new Bomb(s.x,s.y);
						bb.add(b);
					est.remove(i);
				}
			
			}
		for(int i=0;i<mytank.st.size();i++)
		{
			Shot s=mytank.st.get(i);
		if(s!=null&&s.islive==true)
		{
			g.setColor(Color.red);
			//g.drawLine(s.x, s.y, s.x+1, s.y+1);
			g.fillOval(s.x, s.y, 4, 4);
			//g.drawImage(image4, s.x, s.y, 5, 20, this);
		
		}
		if(s.islive==false)
		{
			mytank.st.remove(s);
		}
		}
	}
	public void drawMyTank(int x,int y,Graphics g,int direct)
	{
		switch(direct)
		{
		//上
		case(0):
			//原坦克
		g.setColor(Color.red);
		g.fill3DRect(x, y, 5, 30,false);
		g.fill3DRect(x+15, y, 5, 30,false);
		g.fill3DRect(x+5, y+5, 10, 20,false);
		//g.setColor(Color.orange);
		g.fillOval(x+5, y+10, 10, 10);
		//g.setColor(Color.red);
		g.drawLine(x+10, y,x+10 , y+10);
		/*	//g.drawImage(image6u, x, y, 20, 30, this);
	    g.fillRect(x, y, 10, 40);
		g.fillRect(x+35,y, 10, 40);
		g.fillOval(x+5, y+10, 34, 22);
		g.fillRect(x+20,y-8 , 6, 30);	*/
		
		break;
		//左
		case(1):
		//g.drawLine(x+y, y+10,x+10 , y+10);
			g.setColor(Color.red);
		g.fill3DRect(x-5, y+20, 30, 5,false);
		g.fill3DRect(x-5, y+5,30, 5,false);
		g.fill3DRect(x, y+10, 20, 10,false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15,x-5 , y+15);
		
			//g.drawImage(image6l, x, y, 30,20, this);
			
		break;
		//右
		case(2):
		g.setColor(Color.red);
		g.fill3DRect(x-5, y+20, 30, 5,false);
		g.fill3DRect(x-5, y+5,30, 5,false);
		g.fill3DRect(x, y+10, 20, 10,false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15,x+25 , y+15);
		
			//g.drawImage(image6r, x, y, 30, 20, this);
		break;
		//下
		case(3):
		g.setColor(Color.red);
		g.fill3DRect(x, y, 5, 30,false);
		g.fill3DRect(x+15, y, 5, 30,false);
		g.fill3DRect(x+5, y+5, 10, 20,false);
		//g.setColor(Color.orange);
		g.fillOval(x+5, y+10, 10, 10);
		//g.setColor(Color.red);
		g.drawLine(x+10, y+10,x+10 , y+30);
		
			//g.drawImage(image6d, x, y, 20, 30, this);
		break;
		default:
			break;	
		}
		
	}
	public void hitMyTank(Shot s,MyTank mytank)
	{
		switch(mytank.direct)
		{
		case 0:
		case 4:
			if(s.x>mytank.x&&s.x<mytank.x+20&&s.y>mytank.y&&s.y<mytank.y+30)
			{
				s.islive=false;
				mytank.islive=false;
				//System.out.println("你好");
				//Bomb b=new Bomb(et.x,et.y);
				//bb.add(b);
			}
		case 2:
		case 1:
			if(s.x>mytank.x&&s.x<mytank.x+30&&s.y>mytank.y&&s.y<mytank.y+20)
			{
				s.islive=false;
				mytank.islive=false;
				//Bomb b=new Bomb(et.x,et.y);
				//bb.add(b);
			}
		}
	}
	
	public void changedirc()
	{
		for(int i=0;i<etc.size();i++)
		{
			EnermyTank et=etc.get(i);
			//Wall temp=ww.get(i);
			for(int j=0;j<ww.size();j++)
			{
				Wall temp=ww.get(j);
			switch(et.direct)
			{
			case 0:
			if(et.x>temp.x&&et.x<temp.x+30&&et.y>temp.y&&et.y<temp.y+30)
			{
				//ismove=false;
				//mytank.y--;
				et.direct=4;
				etc.remove(j);
				etc.add(j, et);
			}
			break;
			case 1:
				if(et.x>temp.x&&et.x<temp.x+30&&et.y>temp.y&&et.y<temp.y+30)
				{
					//ismove=false;
					//mytank.x--;
					et.direct=2;
					EnermyTank temp1=et;
					etc.remove(j);
					etc.add(j, temp1);
				}
				break;
			case 2:
				if(et.x+30>temp.x&&et.x<temp.x+30&&et.y>temp.y&&et.y<temp.y+30)
				{
					//ismove=false;
					//mytank.x++;
					et.direct=1;
					etc.remove(j);
					etc.add(j, et);
				}
				break;
			case 3:
				if(et.x>temp.x&&et.x<temp.x+30&&et.y<temp.y&&et.y+30>temp.y)
				{
					//ismove=false;
					//mytank.y++;
					et.direct=0;
					etc.remove(j);
					etc.add(j, et);
				}
				break;
			}
			
		}
		}
	}
	/*public void ismove()
	{
		for(int i=0;i<ww.size();i++)
		{
			Wall temp=ww.get(i);
			switch(mytank.direct)
			{
			case 0:
			if(mytank.x>temp.x&&mytank.x<temp.x+30&&mytank.y>temp.y&&mytank.y<temp.y+30)
			{
				ismove=false;
				//mytank.y--;
			}
			break;
			case 1:
				if(mytank.x>temp.x&&mytank.x<temp.x+30&&mytank.y>temp.y&&mytank.y<temp.y+30)
				{
					ismove=false;
					//mytank.x--;
				}
				break;
			case 2:
				if(mytank.x+30>temp.x&&mytank.x<temp.x+30&&mytank.y>temp.y&&mytank.y<temp.y+30)
				{
					ismove=false;
					//mytank.x++;
				}
				break;
			case 3:
				if(mytank.x>temp.x&&mytank.x<temp.x+30&&mytank.y<temp.y&&mytank.y+30>temp.y)
				{
					ismove=false;
					//mytank.y++;
				}
				break;
			}
			
		}
	}
	*/
	public void hitwall(Shot s,Wall w)
	{
		if(s.x>w.x&&s.x<w.x+30&&s.y>w.y&&s.y<w.y+30)
		{
			s.islive=false;
			ww.remove(w);
		}
	}
	public void hitTank(Shot s,EnermyTank et)
	{
		switch(et.direct)
		{
		case 0:
		case 3:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				s.islive=false;
				et.islive=false;
				//System.out.println("你好");
				//Bomb b=new Bomb(et.x,et.y);
				//bb.add(b);
			}
		case 2:
		case 4:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				s.islive=false;
				et.islive=false;
				//Bomb b=new Bomb(et.x,et.y);
				//bb.add(b);
			}
			
		}
		if(s.islive==false){
			Bomb b=new Bomb(s.x,s.y);
			bb.add(b);
			}
		
	}
	
	/**
	 * @param x
	 * @param y
	 * @param g
	 * @param direct
	 * @param type
	 */
	public void drawEnermyTank(int x,int y,Graphics g,int direct)
	{
		//this.x=x;
		
		/*//this.y=y;
		switch(type)
		{
		case(0):
		g.setColor(Color.red);
		break;
		case(1):
			g.setColor(Color.BLUE);
		break;
		}
		*/
		switch(direct)
		{
		//上
		case(0):
		//g.setColor(Color.red);
			//原坦克
		/*g.fill3DRect(x, y, 5, 30,false);
		g.fill3DRect(x+15, y, 5, 30,false);
		g.fill3DRect(x+5, y+5, 10, 20,false);
		//g.setColor(Color.orange);
		g.fillOval(x+5, y+10, 10, 10);
		//g.setColor(Color.red);
		g.drawLine(x+10, y,x+10 , y+10);
		*/
			g.drawImage(image6u, x, y, 20, 30, this);
	    /*g.fillRect(x, y, 10, 40);
		g.fillRect(x+35,y, 10, 40);
		g.fillOval(x+5, y+10, 34, 22);
		g.fillRect(x+20,y-8 , 6, 30);
		*/
		break;
		//左
		case(1):
		//g.drawLine(x+y, y+10,x+10 , y+10);
		/*g.fill3DRect(x-5, y+20, 30, 5,false);
		g.fill3DRect(x-5, y+5,30, 5,false);
		g.fill3DRect(x, y+10, 20, 10,false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15,x-5 , y+15);
		*/
			g.drawImage(image6l, x, y, 30,20, this);
			
		break;
		//右
		case(2):
		
			/*g.fill3DRect(x-5, y+20, 30, 5,false);
		g.fill3DRect(x-5, y+5,30, 5,false);
		g.fill3DRect(x, y+10, 20, 10,false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15,x+25 , y+15);
		*/
			g.drawImage(image6r, x, y, 30, 20, this);
		break;
		//下
		case(3):
			/*
		g.fill3DRect(x, y, 5, 30,false);
		g.fill3DRect(x+15, y, 5, 30,false);
		g.fill3DRect(x+5, y+5, 10, 20,false);
		//g.setColor(Color.orange);
		g.fillOval(x+5, y+10, 10, 10);
		//g.setColor(Color.red);
		g.drawLine(x+10, y+10,x+10 , y+30);
		*/
			g.drawImage(image6d, x, y, 20, 30, this);
		break;
		default:
			break;	
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(ismove==true)
		{
		if(arg0.getKeyCode()==KeyEvent.VK_UP)
		{
		this.mytank.moveUp();
		mytank.direct=0;
		if(mytank.y<0)
		{
			mytank.y=0;
		}
			//System.out.println("ok");
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			mytank.direct=3;
		this.mytank.moveDown();
		if(mytank.y>470)
		{
			mytank.y=470;
		}
		}
		
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			mytank.direct=1;
		this.mytank.moveL();
		if(mytank.x<0)
		{
			mytank.x=0;
		}
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			mytank.direct=2;
		this.mytank.moveR();
		if(mytank.x>470)
		{
			mytank.x=470;
		}
		}
		 if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			 if(mytank.st.size()<5)
			 {
				 this.mytank.shotenermy();
			 }
		}
		this.repaint();
	}
	}
	public void homeislive()
	{
		for(int i=0;i<est.size();i++)
		{
			Shot s=est.get(i);
		if(s.x>home.x&&s.x<home.x+30&&s.y>home.y&&s.y<home.y+30)
		{
			home.islive=false;
			s.islive=false;
			Bomb b=new Bomb(home.x,home.y);
			bb.add(b);
		}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if(ismove==false)
		{
			switch(mytank.direct)
			{
			case 0:
				mytank.y++;
				break;
			case 1:
				mytank.x++;
				break;
			case 2:
				mytank.x--;
				break;
			case 3:
				mytank.y--;
				break;
				
				
			}
			ismove=true;
		}
		//this.ismove();
		this.changedirc();
		this.homeislive();
		for(int i=0;i<est.size();i++)
		{
			Shot s=est.get(i);
			if(s.islive==true)
			{
				for(int j=0;j<ww.size();j++)
				{
					Wall w=ww.get(j);
					this.hitwall(s, w);
				}
			}
		}
		for(int i=0;i<mytank.st.size();i++)
		{
			Shot s=mytank.st.get(i);
			if(s.islive==true)
			{
				for(int j=0;j<ww.size();j++)
				{
					Wall w=ww.get(j);
					this.hitwall(s, w);
				}
			}
		}
		for(int i=0;i<etc.size();i++)
		{
			//Shot s=mytank.st.get(i);
			EnermyTank et=etc.get(i);
			if(et.islive){
			for(int j=0;j<mytank.st.size();j++)
			{
				//EnermyTank et=etc.get(j);
			    Shot s=mytank.st.get(j);
				if(et.islive){
				this.hitTank(s, et);
				//System.out.println("nihao");
				}
			}
			}
		}
		if(mytank.islive==true)
		{
			for(int i=0;i<est.size();i++)
			{
				Shot s=est.get(i);
				this.hitMyTank(s, mytank);
			}
		}
		while(est.size()<5)
		{
			Shot s=null;
			for(int i=0;i<etc.size();i++)
			{
				EnermyTank et=etc.get(i);
			switch(et.direct)
			{
			case 0:
				s=new Shot(et.x+8,et.y,et.direct);
				est.add(s);
				break;
			case 1:
				s=new Shot(et.x,et.y+8,et.direct);
				est.add(s);
				break;
			case 2:
				s=new Shot(et.x+20,et.y+8,et.direct);
				est.add(s);
				break;
			case 3:
				s=new Shot(et.x+8,et.y+30,et.direct);
				est.add(s);
				break;
			}
			Thread t=new Thread(s);
			t.start();
			System.out.println("OK");
		}
		}
		if(etc.size()<4)
		{
			for(int i=0;i<3;i++)
			{
			EnermyTank et=new EnermyTank(i*100,0);
			etc.add(et);
			Thread t=new Thread(et);
			t.start();
			}
		}
		/*for(int i=0;i<mytank.st.size();i++)
		{
			Shot s=mytank.st.get(i);
			if(s.islive==false)
			{
				Bomb b=new Bomb(s.x,s.y);
				bb.add(b);
			}
		}*/
		/*for(int i=0;i<est.size();i++)
		{
			Shot s=est.get(i);
			if(s.islive==false)
			{
				Bomb b=new Bomb(s.x,s.y);
				etbb.add(b);
			}
		}
		*/
		this.repaint();
	}
	}
}
//坦克类
class Tank
{
	//表示坦克的横坐标;
	int x=0;
	//坦克纵坐标
	int y=0;
	int direct;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
		}
	
}
class EnermyTank extends Tank implements Runnable
{
	boolean islive=true;
	int x=0;
	int y=0;
	public EnermyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		
	}
	/*
	public void shotMytank()
	{
		Shot s=null;
		Vector<Shot> st=new Vector<Shot>();
		switch(this.direct)
		{
		case(0):
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			s=new Shot(x+10,y,0);
		st.add(s);
		}
		break;
		case(1):
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			s=new Shot(x-5,y+10,1);
		st.add(s); 
			}
		break;
		case(2):
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			s=new Shot(x+25,y+15,2);
		st.add(s);
			}
		break;
		case(3):
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			s=new Shot(x+10,y+30,3);
		st.add(s);
			}
		break;
		}
		Thread t=new Thread(s);
		t.start();
		direct=(int)(Math.random()*4);
		if(s.islive==false)
		{
			t.destroy();
		}
	}
	*/
	//Vector<Shot> st=new Vector<Shot> ();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(50);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		while(true)
		{
			Shot s=null;
			switch(direct)
			{
			case 0:
				for(int i=0;i<15;i++)
				{
					try{
						Thread.sleep(100);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					y-=5;
					if(y<0)
					{
						y=0;
					}
				}
				break;
				case 1:
					for(int i=0;i<15;i++)
					{
						try{
							Thread.sleep(100);
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}
						x-=5;
						if(x<0)
						{
							x=0;
						}
						}
					break;
				case 2:
					for(int i=0;i<15;i++)
					{
						try{
							Thread.sleep(100);
						}catch(InterruptedException e)
						{
							e.printStackTrace();
						}
						x+=5;	
						if(x>470)
						{
							x=470;
						}
					}
					break;
					case 3:
						for(int i=0;i<15;i++)
						{
							try{
								Thread.sleep(100);
							}catch(InterruptedException e)
							{
								e.printStackTrace();
							}
							y+=5;
							if(y>470)
							{
								y=470;
							}
						}
						break;
					
				}
			//System.out.println("heihei");
			this.direct=(int)(Math.random()*4);
			if(islive==false)
			{
				break;
			}
			}
		}
		
	}
class MyTank extends Tank
{
	boolean islive=true;
	public void moveUp()
	{
		y-=1;
	}
	public void moveDown()
	{
		y+=1;
	}
	public void moveR()
	{
		x+=1;
	}
	public void moveL(){
		x-=1;
	}
	public MyTank(int x,int y)
	{
		super(x,y);
		//画出我的Tank	
	}
	Vector<Shot> st=new Vector<Shot>();
	public void shotenermy()
	{
		Shot s=null;
		switch(this.direct)
		{
		case(0):
			s=new Shot(x+8,y,0);
		st.add(s);
		break;
		case(1):
			s=new Shot(x-5,y+13,1);
		st.add(s);    
		break;
		case(2):
			s=new Shot(x+25,y+13,2);
		st.add(s);
		break;
		case(3):
			s=new Shot(x+8,y+30,3);
		st.add(s);
		break;
		
		}
		Thread t1=new Thread(s);
		t1.start();

	}
}
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	boolean islive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
		//this.direct=direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		switch(direct)
		{
		case(0):
			y-=6;
		break;
		case(1):
			x-=6;
		break;
		case(2):
		    x+=6;
		break;
		case(3):
			y+=6;
		break;
		}
		if(x<0||x>500||y<0||y>500)
		{
			this.islive=false;
			//System.out.println("子弹线程死亡");
			break;
			
		}
		
		//System.out.println(+y);
	}
		
	}
}
class Bomb
{
	int x;
	int y;
	int time=7;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void lifeDown()
	{
		time--;
	}
}
class Home
{
	int x;
	int y;
	boolean islive=true;
	public Home(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}