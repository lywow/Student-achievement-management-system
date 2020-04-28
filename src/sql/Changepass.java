package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javabean.Student;
import javabean.Teacher;

@WebServlet("/changepass.do")
public class Changepass extends HttpServlet{
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
		if(request.getParameter("type").equals("student_pass"))
		{
			String oldpass=request.getParameter("oldpass");
			String newpass=request.getParameter("newpass");
			String toopass=request.getParameter("toopass");
			Student stu=(Student)request.getSession().getAttribute("student");
			String stuno=stu.getno().trim();
			String stupass=stu.getpass().trim();
			
			if(oldpass.equals(stupass))
			{
				if(newpass.equals(toopass))
				{
					try
					{
						String sql="update Qinjj_Student10 set qjj_Spass10=? where qjj_Sno10=? and qjj_Spass10=?";
						Connection dbconn=ds.getConnection();
						PreparedStatement pstmt=dbconn.prepareStatement(sql);
						pstmt.setString(1,newpass);
						pstmt.setString(2,stuno);
						pstmt.setString(3,oldpass);
						if(pstmt.executeUpdate()==1)
						{
					        pstmt.close();
					        dbconn.close();
					    	request.getSession().setAttribute("error", "修改成功");
							response.sendRedirect("student.jsp");
							return;
						}
						else
						{
						    pstmt.close();
						    dbconn.close();
						    request.getSession().setAttribute("error", "数据修改失败");
							response.sendRedirect("student.jsp");
							return;
						}
					}
					catch(SQLException e)
					{e.printStackTrace();}
				}
				else
				{
					request.getSession().setAttribute("error", "学号或密码错误");
					response.sendRedirect("student.jsp");
					return;
				}
			}
			else
			{
				System.out.println("原密码输入错误");
				request.getSession().setAttribute("error", "原密码输入错误");
				response.sendRedirect("student.jsp");
				return;
			}
		}
		
		if(request.getParameter("type").equals("teacher_pass"))
		{
			if(request.getParameter("type").equals("teacher_pass"))
			{
				String oldpass=request.getParameter("oldpass");
				String newpass=request.getParameter("newpass");
				String toopass=request.getParameter("toopass");
				Teacher tea=(Teacher)request.getSession().getAttribute("teacher");
				String teano=tea.getno().trim();
				String teapass=tea.getpass().trim();
				
				if(oldpass.equals(teapass))
				{
					if(newpass.equals(toopass))
					{
						try
						{
							String sql="update Qinjj_Teacher10 set qjj_Tpass10=? where qjj_Tno10=? and qjj_Tpass10=?";
							Connection dbconn=ds.getConnection();
							PreparedStatement pstmt=dbconn.prepareStatement(sql);
							pstmt.setString(1,newpass);
							pstmt.setString(2,teano);
							pstmt.setString(3,oldpass);
							if(pstmt.executeUpdate()==1)
							{
						        pstmt.close();
						        dbconn.close();
						    	request.getSession().setAttribute("error", "修改成功");
								response.sendRedirect("teacher.jsp");
								return;
							}
							else
							{
							    pstmt.close();
							    dbconn.close();
							    request.getSession().setAttribute("error", "数据修改失败");
								response.sendRedirect("teacher.jsp");
								return;
							}
						}
						catch(SQLException e)
						{e.printStackTrace();}
					}
					else
					{
						request.getSession().setAttribute("error", "工号或密码错误");
						response.sendRedirect("teacher.jsp");
						return;
					}
				}
				else
				{
					System.out.println("原密码输入错误");
					request.getSession().setAttribute("error", "原密码输入错误");
					response.sendRedirect("teacher.jsp");
					return;
				}
			}
		}
	}
}
