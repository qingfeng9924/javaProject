package com.bshandle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqldb.ExpSQLdb;

import java.sql.*;

/**
 * Servlet implementation class ConfirmLogin
 */
@WebServlet("/ConfirmLogin")
public class ConfirmLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
    public ConfirmLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("charset=utf-8");
		String pwd=request.getParameter("accpwd");
		String acct=request.getParameter("acct");
		String val=request.getParameter("iskeepacct");
		if(val!=null&&val.equals("keep"))
		{
			Cookie cookie=new Cookie("acct",acct);
			cookie.setMaxAge(3600*6*24);
			response.addCookie(cookie);
		}
		try {
			Class.forName(ExpSQLdb.driver);
			con=DriverManager.getConnection(ExpSQLdb.url,ExpSQLdb.name,ExpSQLdb.pwd);
			ps=con.prepareStatement("select * from LoginPerson where l_name=? and l_pwd=?");
			ps.setString(1, acct);
			ps.setString(2,pwd );
			//System.out.println(pwd+acct);
			rs=ps.executeQuery();
			if(rs.next())
			{
				//request.setAttribute("a", "用户名或者密码错误");
				request.getRequestDispatcher("/MainPanel").forward(request, response);
				System.out.println("登录成功");
			}else{
				request.setAttribute("err", "用户名或者密码错误");
				request.getRequestDispatcher("/LoginPanel").forward(request, response);
				System.out.println("ok");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} try {
			if(rs!=null)
			{
				rs.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
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
