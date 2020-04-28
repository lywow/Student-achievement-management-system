package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javabean.Course;
import javabean.Student;
import javabean.Student_Grade;
import javabean.Teacher;
import javabean.Teacher_Course;

@WebServlet("/other.do")
public class OtherServlet extends HttpServlet{
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
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		ArrayList<String> inte=(ArrayList<String>)request.getSession().getAttribute("inte");
		String chan=request.getQueryString();
		
		if(inte.get(0).equals("1"))
		{
			System.out.println("1--111");
			try
			{
				String sql="select * from Qinjj_Student10 where qjj_Sno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,chan);
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
					request.getSession().setAttribute("gggg", stu);
					
					rst.close();
		            pstmt.close();
		            dbconn.close();
				}
				else
				{
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("error", "错误");
					response.sendRedirect("admin.do?10");
					return;
				}
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(inte.get(1).equals("1"))
		{
			System.out.println("1--2221");
			try
			{
				String sql="select * from Qinjj_Teacher10 where qjj_Tno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,chan);
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
					request.getSession().setAttribute("gggg", tea);
					
					rst.close();
		            pstmt.close();
		            dbconn.close();
				}
				else
				{
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("error", "错误");
					response.sendRedirect("admin.do?01");
					return;
				}
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(inte.get(2).equals("1"))
		{
			System.out.println("1--333");
			try
			{
				String sql="select * from Qinjj_Course10 where qjj_Cno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,chan);
				ResultSet rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					Course cou=new Course(
								rst.getString("qjj_Cno10"),
								rst.getString("qjj_Cname10"),
								rst.getString("qjj_Cterm10"),
								rst.getString("qjj_Ctestway10"),
								rst.getInt("qjj_Ccredit10"),
								rst.getInt("qjj_Ctime10"));
					request.getSession().setAttribute("gggg", cou);
					
					rst.close();
		            pstmt.close();
		            dbconn.close();
				}
				else
				{
					rst.close();
		            pstmt.close();
		            dbconn.close();
					request.getSession().setAttribute("error", "错误");
					response.sendRedirect("admin.do?01");
					return;
				}
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(inte.get(3).equals("1"))
		{
			System.out.println("1--444");
			String str=(String)request.getSession().getAttribute("noo");
			int sss=Integer.parseInt(str);
			ArrayList<Teacher_Course> mclist=(ArrayList<Teacher_Course>)request.getSession().getAttribute("mycourse");
			Teacher_Course mc=mclist.get(sss);
			Teacher tt=(Teacher)request.getSession().getAttribute("teacher");
			String no=tt.getname().trim();
			ArrayList<Student_Grade> sglist=new ArrayList<Student_Grade>();
			
			try
			{
				String sql="select * from Qinjj_stu_grade_view10 where qjj_Tname10=? and qjj_Classno10=? and qjj_Cno10=? order by qjj_Grade10 DESC";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,no);
				pstmt.setString(2,mc.getClassno());
				pstmt.setString(3,mc.getCno());
				ResultSet rst=pstmt.executeQuery();
				
				while(rst.next())
				{
					Student_Grade sg=new Student_Grade(
							rst.getString("qjj_Sno10"),
							rst.getString("qjj_Cno10"),
							rst.getString("qjj_Cname10"),
							rst.getString("qjj_Cterm10"),
							rst.getInt("qjj_Grade10"),
							rst.getString("qjj_Tname10"));
					
					sglist.add(sg);
				}
			    request.getSession().setAttribute("gggg", sglist);
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(inte.get(4).equals("1"))
		{
			System.out.println("1--555");
			String str=(String)request.getSession().getAttribute("noo");
			int sss=Integer.parseInt(str);
			ArrayList<Teacher_Course> mclist=(ArrayList<Teacher_Course>)request.getSession().getAttribute("mycourse");
			Teacher_Course mc=mclist.get(sss);
			Teacher tt=(Teacher)request.getSession().getAttribute("teacher");
			String no=tt.getname().trim();
			ArrayList<Student_Grade> sglist=new ArrayList<Student_Grade>();
			
			try
			{
				String sql="select * from Qinjj_CCTS_view10 where qjj_Tname10=? and qjj_Classno10=? and qjj_Cno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,no);
				pstmt.setString(2,mc.getClassno());
				pstmt.setString(3,mc.getCno());
				ResultSet rst=pstmt.executeQuery();
				
				while(rst.next())
				{
					Student_Grade sg=new Student_Grade(
							rst.getString("qjj_Sno10"),
							rst.getString("qjj_Cno10"),
							rst.getString("qjj_Cname10"),
							null,
							0,
							rst.getString("qjj_Tname10"));
					sg.setTno(rst.getString("qjj_Tno10"));
					System.out.println(sg.getSno());
					sglist.add(sg);
				}
			    request.getSession().setAttribute("gggg", sglist);
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		
		response.sendRedirect("other.jsp");
	}
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("type").equals("ch_student"))
		{
			String sno=request.getParameter("sno").trim();
			String sname=request.getParameter("sname").trim();
			String spass=request.getParameter("pass").trim();
			String classno=request.getParameter("classno").trim();
			String sex=request.getParameter("sex").trim();
			String place=request.getParameter("place").trim();
			int age=Integer.parseInt(request.getParameter("age"));
			int credit=Integer.parseInt(request.getParameter("credit"));
			String old=request.getParameter("noing").trim();
			
			try
			{
				String sql="update Qinjj_Student10 "
						+ "set qjj_Sno10=?,qjj_Spass10=?,qjj_Classno10=?,qjj_Sname10=?,qjj_Ssex10=?,qjj_Sage10=?,qjj_Scredit10=?,qjj_Splace10=? "
						+ "where qjj_Sno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,sno);
				System.out.println(sno);
				pstmt.setString(2,spass);
				System.out.println(spass);
				pstmt.setString(3,classno);
				System.out.println(classno);
				pstmt.setString(4,sname);
				System.out.println(sname);
				pstmt.setString(5,sex);
				System.out.println(sex);
				pstmt.setInt(6,age);
				System.out.println(age);
				pstmt.setInt(7,credit);
				System.out.println(credit);
				pstmt.setString(8,place);
				System.out.println(place);
				pstmt.setString(9,old);
				System.out.println(old);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "学生-"+sname+"-修改成功");System.out.println("学生-"+sname+"-修改成功");}
				else
				{request.getSession().setAttribute("error", "修改失败");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "修改失败");}
		}
		else if(request.getParameter("type").equals("ch_teacher"))
		{
			String old=request.getParameter("noing").trim();
			String tno=request.getParameter("tno").trim();
			String tname=request.getParameter("tname").trim();
			String title=request.getParameter("title").trim();
			String sex=request.getParameter("sex").trim();
			String phone=request.getParameter("phone").trim();
			String tpass=request.getParameter("pass").trim();
			int age=Integer.parseInt(request.getParameter("age"));
			
			try
			{
				String sql="update Qinjj_Teacher10 "
						+ "set qjj_Tno10=?,qjj_Tpass10=?,qjj_Tname10=?,qjj_Ttitle10=?,qjj_Tsex10=?,qjj_Tage10=?,qjj_Tphone10=? "
						+ "where qjj_Tno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,tno);
				pstmt.setString(2,tpass);
				pstmt.setString(3,tname);
				pstmt.setString(4,title);
				pstmt.setString(5,sex);
				pstmt.setInt(6, age);
				pstmt.setString(7,phone);
				pstmt.setString(8,old);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "教师-"+tname+"-修改成功");}
				else
				{request.getSession().setAttribute("error", "修改失败");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "修改失败");}
		}
		else if(request.getParameter("type").equals("ch_course"))
		{
			String old=request.getParameter("noing").trim();
			String cno=request.getParameter("cno").trim();
			String cname=request.getParameter("cname").trim();
			String term=request.getParameter("term").trim();
			int time=Integer.parseInt(request.getParameter("time"));
			String way=request.getParameter("way").trim();
			int credit=Integer.parseInt(request.getParameter("credit"));
			
			try
			{
				String sql="update Qinjj_Course10 " 
						+ "set qjj_Cno10=?,qjj_Cname10=?,qjj_Cterm10=?,qjj_Ctime10=?,qjj_Ctestway10=?,qjj_Ccredit10=? "
						+ "where qjj_Cno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,cno);
				pstmt.setString(2,cname);
				pstmt.setString(3,term);
				pstmt.setInt(4,time);
				pstmt.setString(5,way);
				pstmt.setInt(6, credit);
				pstmt.setString(7,old);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "课程-"+cname+"-修改成功");}
				else
				{request.getSession().setAttribute("error", "修改失败");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "修改失败");}
		}
		else if(request.getParameter("type").equals("ch_grade"))
		{
			String str=(String)request.getSession().getAttribute("noo");
			int sss=Integer.parseInt(str);
			ArrayList<Teacher_Course> mclist=(ArrayList<Teacher_Course>)request.getSession().getAttribute("mycourse");
			Teacher_Course mc=mclist.get(sss);
			Teacher tt=(Teacher)request.getSession().getAttribute("teacher");
			String no=tt.getno().trim();
			ArrayList<Student_Grade> old=(ArrayList<Student_Grade>)request.getSession().getAttribute("gggg");
			
			try
			{
				String sql="delete from Qinjj_Report10 where qjj_Tno10=? and qjj_Cno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,no);
				pstmt.setString(2,mc.getCno());
				pstmt.executeUpdate();

				System.out.println("已完成数据删除");
				for(Student_Grade sg:old)
				{
					int i=Integer.parseInt(request.getParameter(sg.getSno()));
					String sql1="insert into Qinjj_Report10 values(?,?,?,?)";
					pstmt=dbconn.prepareStatement(sql1);
					pstmt.setString(1,sg.getSno());
					pstmt.setString(2,sg.getCno());
					pstmt.setString(3,sg.getTno());
					pstmt.setInt(4,i);
					if(pstmt.executeUpdate()==1)
					{continue;}
					else
					{request.getSession().setAttribute("error", "添加失败");break;}
				}
				request.getSession().setAttribute("error", "添加成功");
			    pstmt.close();
			    dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "修改失败");}
		}
		
		response.sendRedirect("other.jsp");
	}
}


