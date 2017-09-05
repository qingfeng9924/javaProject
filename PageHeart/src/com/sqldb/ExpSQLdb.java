package com.sqldb;

import java.sql.*;
import java.util.Vector;
public class ExpSQLdb
{
	public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url="jdbc:sqlserver://localhost:1433;DatabaseName=Exp";
	public static String name="sa";
	public static String pwd="qingfeng";
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public Vector row,col;
	public ExpSQLdb()
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url);
			ps=con.prepareStatement("select * from LoginPerson");
			rs=ps.executeQuery();
			row=new Vector();
			col=new Vector();
			col.add("–’√˚");
			col.add("√‹¬Î");
			while(rs.next())
			{
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				row.add(hang);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs!=null)
			{
				rs.close();
			}if(ps!=null)
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
}