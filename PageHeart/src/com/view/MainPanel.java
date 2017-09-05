package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPanel
 */
@WebServlet("/MainPanel")
public class MainPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPanel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<head><link type='text/css' rel='stylesheet' href='MainPane.css'></head>");
		pw.println("<body>");
		//pw.println("<img src='images/pic_1.gif'/><br/>");
		//pw.println("<span>��ӭ�����,</span>"+request.getParameter("acct")+"<br/>");
		//pw.println("ok");
		pw.println("<span style='background-color:gray'>"
				+"<a href='#' class='a2'>ҳ����ҳ</a>"
				+"<a href='#' class='a2'>�ҵ�ҳ��</a>"
				+ "<a href='#' class='a2'>�ҹ�ע��Ʒ��</a>"
				+ "<a href='#' class='a2'>�ҵĹ��ﳵ</a>"
				+ "<a href='#' class='a2'>�ղؼ�</a>"
				+ "<a href='#' class='a2'>�ҵ�����</a>"
				+ "<a href='#' class='a2'>�˳���¼</a>"
				+ "<a href='#' class='a2'>��վ����</a></span><br/>"
				);
		/*
		 * С��ҳ��
		 */
		pw.println("<a href='/PageHeart/MainPanel'><img src='images/yexin.gif'/></a><a href='#'><img src='images/Attention.JPG' style='margin-left:300px;'/></a><br/>");
		pw.println("<div class='div1'>");
		pw.println("<form action='#' method='post'>");
		pw.println("<div class='div2'>"
				+ "<table style='width:200px;height:400px;'>");
		pw.println("<tr><td  onmouseover='showTable()' onmouseout='hideTable()'><a href='#' id='a3' style='color:white;text-decoration:none'>   �ֻ� </a></td></tr><tr><td><a href='#' style='color:white;text-decoration:none'>   �ʼǱ� ƽ��</a>"
				+ "</td>></tr><tr><td><a href='#' style='color:white;text-decoration:none'>   ���� ����</a></td></tr><tr><td><a href='#' style='color:white;text-decoration:none'>   �绰�� �ƶ�</a></td></tr>"
				+ "<tr><td><a href='#' style='color:white;text-decoration:none'>   �ƶ���Դ �ֻ�</a></td></tr><tr><td><a href='#' style='color:white;text-decoration:none'>   ���ܼҾ� ����</a></td></tr>");
		pw.println("</table></div><table class='table1' onmouseover='showTable()' onmouseout='hideTable()' id='table_phone'><tr><td><a href='#' class='a1'><img src='images/mi5s.JPG'/>   С��5s</a></td><td><a href='#' class='a1'><img src='images/mi5s.JPG'/>   С��5s</a></td></tr><tr><td><a href='#' class='a1'><img src='images/redmi3s.JPG'/>   ����3s</a></td><td><a href='#' class='a1'><img src='images/mi5plus.JPG'/>   С��5splus</a></td></tr><tr><td><a href='#' class='a1'><img src='images/mi5plus.JPG'/>   С��5splus</a></td><td><a href='#' class='a1'><img src='images/mi5plus.JPG'/>   С��5splus</a></td></tr><tr><td><a href='#' class='a1'><img src='images/mi5plus.JPG'/>   С��5splus</a></td><td><a href='#' class='a1'><img src='images/mi5plus.JPG'/>   С��5splus</a></td></tr></table></form>");
		pw.println("<div class='div3'><img width='850px' height='430px' src='images/mainPic_1.JPG' id='mainimg'/></div><br/><br/>");
		pw.println("</div>");
		/*
		 * ƻ��ҳ��
		 */
		//pw.println("<a href='#'><img src='images/Attention.JPG' style='margin-left:300px;'/></a><br/>");
		pw.println("<img width='100px' src='images/apple.jpg'><a href='#'><img src='images/Attention.JPG' style='margin-left:300px;'/></a><br/>");
		pw.println("<div class='div4'><div class='div5'><a href='#' class='a4'><img src='images/ip7p.JPG' width='100px'/>iphone7plus<br/>�����¼�</a></div><div class='div4'><div class='div5'><a href='#' class='a4'><img src='images/ip7p.JPG' width='100px'/>iphone7plus<br/>�����¼�</a></div><div class='div4'><div class='div5'><a href='#' class='a4'><img src='images/ip7p.JPG' width='100px'/>iphone7plus<br/>�����¼�</a></div><div class='div4'><div class='div5'><a href='#' class='a4'><img src='images/ip7p.JPG' width='100px'/>iphone7plus<br/>�����¼�</a></div><div class='div5'><a href='#'class='a4'><img src='images/ip6s.JPG'  width='100px'/>iphone6splus<br/>�����¼�</a></div><div class='div5'><a href='#'class='a4'><img src='images/ip6s.JPG'  width='100px'/>iphone6splus<br/>�����¼�</a></div><div class='div5'><a href='#' class='a4'><img src='images/ip6s.JPG'  width='100px'/>iphone6splus<br/>�����¼�</a></div></div>");
		pw.println("<br/><big><big>���ǲ�Ʒ</big></big>");
		/*
		 * ���ǲ�Ʒ
		 */
		pw.println("<hr/><br/>");
		pw.println("<div class='div6'><table style='width:1100px;height:710px;'><tr><td><a href='#' class='a5'><img src='images/redmi3x.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmtv.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmmax.JPG'width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmpb.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmlp.JPG' width='150px'/></br>�������</a></td></tr>"
				+ "<tr><td><a href='#' class='a5'><img src='images/redmi3x.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmtv.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmmax.JPG'width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmpb.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmlp.JPG' width='150px'/></br>�������</a></td></tr>"
				+ "<tr><td><a href='#' class='a5'><img src='images/redmi3x.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmtv.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmmax.JPG'width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmpb.JPG' width='150px'/></br>�������</a></td><td><a href='#' class='a5'><img src='images/xmlp.JPG' width='150px'/></br>�������</a></td></tr></table></div>");
		/*
		 * ֻ��Ӳ��
		 */
		pw.println("<br/><big><big>����Ӳ��</big></big>");
		pw.println("<hr/><br/>");
		pw.println("<div class='div9'><div class='div7'><a href='#' class='a5'><img src='images/xmjhq.JPG' width='300px' height='680px'/><br/>С�׿���������</a></div><div class='div8'><table style='width:720;height:350;'><tr><td><a href='#' class='a5'><img src='images/xmly.JPG' width='170px' height='330px'/><br/>С��·����</a></td><td><a href='#' class='a5'><img src='images/xmtd.JPG' width='170px' height='330px'/><br/>С��̨��</a></td><td><a href='#' class='a5'><img src='images/xmphc.JPG' width='170px' height='330px'/><br/>С��ƽ�⳵</a></td><td><a href='#' class='a5'><img src='images/xmmt.JPG' width='170px' height='330px'/><br/>С����ͻ</a></td></tr></table>"
				+ "</div><div class='div8'><table style='width:720;height:350;'><tr><td><a href='#' class='a5'><img src='images/xmly.JPG' width='170px' height='330px'/><br/>С��·����</a></td><td><a href='#' class='a5'><img src='images/xmtd.JPG' width='170px' height='330px'/><br/>С��̨��</a></td><td><a href='#' class='a5'><img src='images/xmphc.JPG' width='170px' height='330px'/><br/>С��ƽ�⳵</a></td><td><a href='#' class='a5'><img src='images/xmmt.JPG' width='170px' height='330px'/><br/>С������</a></td></tr></table></div></div>");
		pw.println("<script language='javascript'>"
				+ "var i=0;"
				+ "function $(id){return document.getElementById(id);}"
				+ "function changeImg(){i++;if(i>3)i=1;$('mainimg').src='images/mainPic_'+i+'.JPG'}"
				+ "function showTable(){$('table_phone').style.display='block';$('a3').style.color='red';}"
				+ "function hideTable(){$('table_phone').style.display='none';$('a3').style.color='white';}"
				+ "setInterval('changeImg()',3000)"
				+ "</script>");
		pw.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
