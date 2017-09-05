package com.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPanel
 */
@WebServlet("/LoginPanel")
public class LoginPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPanel() {
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
		Cookie []cookies=request.getCookies();
		String acct="";
		if(cookies!=null)
		{
			for(Cookie cookie:cookies)
			{
				if(cookie.getName().equals("acct"))
				{
					acct=cookie.getValue();
					//System.out.println("acct="+acct);
				}
			}
		}
		pw.println("<img src='images/pic_1.gif'/><span style='color:blue;margin-left:50px;'>Welcom</span>");
		pw.println("<form method='get' action='/PageHeart/ConfirmLogin'>");
		pw.println("账号：<input type='text' name='acct' style='width:200px;height:30px' value='"+acct+"'/><input type='checkbox' value='keep' name='iskeepacct'>是否保存账户</br>");
		pw.println("密码：<input type='password' name='accpwd' style='width:200px;height:30px'/></br>");
		pw.println("<input type='submit' value='登录' style='margin-left:48px;width:70px;background-color:yellow'>");
		pw.println("<a href='#' style='color:red;margin-left:170px'>忘记密码？</a>");
		pw.println("<a style='color:red' href='#'>新用户?</a>");
		pw.println("</form>");
//		pw.println("<audio src='audios/a.m4a' autoplay='true'>");
//		pw.println("<form method='get' action='#'>");
//		pw.println("<input type='submit' value='新用户'>");
//		pw.println("</form>");
		String err=(String) request.getAttribute("err");
		//System.out.println("err="+err);
		if(err!=null)
		{
			System.out.println("err="+err);
			pw.println(err);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
