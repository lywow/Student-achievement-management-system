package sql;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

import javabean.Class_Cou_Tea;
import javabean.Student;
import javabean.Student_Grade;
import javabean.Teacher;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	DataSource ds;

	public void init()
	{
		try
		{
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/lexDS");
		}
		catch(NamingException e1)
		{System.out.println(e1);}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		int abc=0;
		if(request.getParameter("type").equals("student_login"))
		{
			String user=request.getParameter("username");
			String pw=request.getParameter("password");
			
			try
			{
				String sql="select * from Qinjj_Student10 where qjj_Sno10=? and qjj_Spass10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,user);
				pstmt.setString(2,pw);
				ResultSet rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					Student stu=new Student();
					stu.setno(rst.getString("qjj_Sno10"));
					stu.setpass(rst.getString("qjj_Spass10"));
					stu.setname(rst.getString("qjj_Sname10"));
					stu.setage(rst.getInt("qjj_Sage10"));
					stu.setclassno(rst.getString("qjj_Classno10"));
					stu.setsex(rst.getString("qjj_Ssex10"));
					stu.setplace(rst.getString("qjj_Splace10"));
					stu.setcreidt(rst.getInt("qjj_Scredit10"));
					request.getSession().setAttribute("student", stu);
					response.sendRedirect("student.do?01");
					abc=1;
				}
				else
				{
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("error", "—ß∫≈ªÚ√‹¬Î¥ÌŒÛ");
					response.sendRedirect("index.jsp");
					return;
				}
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(request.getParameter("type").equals("teacher_login"))
		{
			String user=request.getParameter("id");
			String pw=request.getParameter("password");
			
			try
			{
				String sql="select * from Qinjj_Teacher10 where qjj_Tno10=? and qjj_Tpass10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,user);
				pstmt.setString(2,pw);
				ResultSet rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					Teacher tea=new Teacher(
							rst.getString("qjj_Tno10"), 
							rst.getString("qjj_Tname10"), 
							rst.getString("qjj_Tpass10"), 
							rst.getString("qjj_Ttitle10"), 
							rst.getString("qjj_Tsex10"), 
							rst.getInt("qjj_Tage10"), 
							rst.getString("qjj_Tphone10"));
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("teacher", tea);
					response.sendRedirect("teacher.do?01");
					abc=2;
				}
				else
				{
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("error", "π§∫≈ªÚ√‹¬Î¥ÌŒÛ");
					response.sendRedirect("index.jsp");
					return;
				}
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(request.getParameter("type").equals("admin_login"))
		{
			String id=request.getParameter("id");
			String pw=request.getParameter("password");
			
			if(id.equals("admin")&&pw.equals("admin"))
			{
				response.sendRedirect("admin.do?01");
			}
			else
			{
				request.getSession().setAttribute("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				response.sendRedirect("alogin.jsp");
				return;
			}
		}
	}
}














