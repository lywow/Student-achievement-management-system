package sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javabean.Alone_Grade;
import javabean.Class_Cou_Tea;
import javabean.Course;
import javabean.Student;
import javabean.Student_Interface;
import javabean.Teacher;
import javabean.Teacher_Course;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet{
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
		request.setCharacterEncoding("utf-8");
		
		if(request.getParameter("type").equals("chan"))
		{
			ArrayList<String> inte = new ArrayList<String> ();
			for(int i=0;i<5;i++){inte.add("none");}
			
			String no=request.getParameter("no");
			if(request.getParameter("type1").equals("student"))
			{inte.set(0, "1");}
			if(request.getParameter("type1").equals("teacher"))
			{inte.set(1, "1");}
			if(request.getParameter("type1").equals("course"))
			{inte.set(2, "1");}
			
			request.getSession().setAttribute("inte", inte);
			response.sendRedirect("other.do?"+no);
			return;
		}
		
		if(request.getParameter("type").equals("add_student"))
		{
			String sno=request.getParameter("sno");
			String sname=request.getParameter("sname");
			String classno=request.getParameter("classno");
			String sex=request.getParameter("sex");
			String place=request.getParameter("place");
			int age=Integer.parseInt(request.getParameter("age"));
			
			try
			{
				String sql="insert into Qinjj_Student10 values(?,'123456',?,?,?,?,0,?)";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,sno);
				pstmt.setString(2,classno);
				pstmt.setString(3,sname);
				pstmt.setString(4,sex);
				pstmt.setString(6,place);
				pstmt.setInt(5, age);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "Ñ§Éú-"+sname+"-Ìí¼Ó³É¹¦");}
				else
				{request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		}
		else if(request.getParameter("type").equals("add_teacher"))
		{
			String tno=request.getParameter("tno");
			String tname=request.getParameter("tname");
			String title=request.getParameter("title");
			String sex=request.getParameter("sex");
			String phone=request.getParameter("phone");

			int age=Integer.parseInt(request.getParameter("age"));
			
			try
			{
				String sql="insert into Qinjj_Teacher10 values(?,?,?,?,?,?,'123456')";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,tno);
				pstmt.setString(2,tname);
				pstmt.setString(3,sex);
				pstmt.setString(5,title);
				pstmt.setString(6,phone);
				pstmt.setInt(4, age);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "½ÌÊ¦-"+tname+"-Ìí¼Ó³É¹¦");}
				else
				{request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		}
		else if(request.getParameter("type").equals("add_course"))
		{
			String cno=request.getParameter("cno");
			String cname=request.getParameter("cname");
			String term=request.getParameter("term");
			int time=Integer.parseInt(request.getParameter("time"));
			String way=request.getParameter("way");
			int credit=Integer.parseInt(request.getParameter("credit"));
			
			try
			{
				String sql="insert into Qinjj_Course10 values(?,?,?,?,?,?)";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,cno);
				pstmt.setString(2,cname);
				pstmt.setString(3,term);
				pstmt.setInt(4,time);
				pstmt.setString(5,way);
				pstmt.setInt(6, credit);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "¿Î³Ì-"+cname+"-Ìí¼Ó³É¹¦");}
				else
				{request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "Ìí¼ÓÊ§°Ü");}
		}
		else if(request.getParameter("type").equals("alonesno"))
		{
			String sno=request.getParameter("sno");
			System.out.println(sno);
			ArrayList<Student> stulist=new ArrayList<Student>();
			try
			{
			    String sql="select * from Qinjj_Student10 where qjj_Sno10=?";
			    Connection dbconn=ds.getConnection();
			    PreparedStatement pstmt=dbconn.prepareStatement(sql);
			    pstmt.setString(1,sno);
			    ResultSet rst=pstmt.executeQuery();
				while(rst.next())
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
					stulist.add(stu);
				}
				request.getSession().setAttribute("allstudent", stulist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		else if(request.getParameter("type").equals("allcourse"))
		{
			String term=request.getParameter("term");
			ArrayList<Course> coulist=new ArrayList<Course>();
			try
			{
				Connection dbconn=ds.getConnection();
				String sql="select * from Qinjj_Course10";
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				ResultSet rst=pstmt.executeQuery();
				while(rst.next())
				{
					Course cou=new Course(
							rst.getString("qjj_Cno10"),
							rst.getString("qjj_Cname10"),
							rst.getString("qjj_Cterm10"),
							rst.getString("qjj_Ctestway10"),
							rst.getInt("qjj_Ccredit10"),
							rst.getInt("qjj_Ctime10"));
					if(term.equals("all"))
					{coulist.add(cou);}
					else if(term.equals(cou.getCterm()))
					{coulist.add(cou);}
				}
			    request.getSession().setAttribute("allcourse", coulist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		else if(request.getParameter("type").equals("aloneplace"))
		{
			String place=request.getParameter("place");
			System.out.println(place);
			ArrayList<Student> stulist=new ArrayList<Student>();
			try
			{
			    String sql="select * from Qinjj_Student10";
			    Connection dbconn=ds.getConnection();
			    PreparedStatement pstmt=dbconn.prepareStatement(sql);
			    ResultSet rst=pstmt.executeQuery();
				while(rst.next())
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
					if(place.equals("all")){stulist.add(stu);}
					else if(place.equals(stu.getplace().trim())){stulist.add(stu);}
				}
				request.getSession().setAttribute("allstudent", stulist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		else if(request.getParameter("type").equals("alonetno"))
		{
			String tno=request.getParameter("tno");
			System.out.println(tno);
			ArrayList<Teacher> tealist=new ArrayList<Teacher>();
			try
			{
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt;
				ResultSet rst;
				
				String sql="select * from Qinjj_Teacher10 where qjj_Tno10=?";
				pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,tno);
				rst=pstmt.executeQuery();
				while(rst.next())
				{
					Teacher tea=new Teacher(
							rst.getString("qjj_Tno10"), 
							rst.getString("qjj_Tname10"), 
							rst.getString("qjj_Tpass10"), 
							rst.getString("qjj_Ttitle10"), 
							rst.getString("qjj_Tsex10"), 
							rst.getInt("qjj_Tage10"), 
							rst.getString("qjj_Tphone10"));
					tealist.add(tea);
				}
				request.getSession().setAttribute("allteacher", tealist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		else if(request.getParameter("type").equals("alonecno"))
		{
			String cno=request.getParameter("cno");
			ArrayList<Course> coulist=new ArrayList<Course>();
			System.out.println(cno);

			try
			{
			    String sql="select * from Qinjj_Course10 where qjj_Cno10=?";
			    Connection dbconn=ds.getConnection();
			    PreparedStatement pstmt=dbconn.prepareStatement(sql);
			    pstmt.setString(1,cno);
			    ResultSet rst=pstmt.executeQuery();
				while(rst.next())
				{
					Course cou=new Course(
							rst.getString("qjj_Cno10"),
							rst.getString("qjj_Cname10"),
							rst.getString("qjj_Cterm10"),
							rst.getString("qjj_Ctestway10"),
							rst.getInt("qjj_Ccredit10"),
							rst.getInt("qjj_Ctime10"));
					coulist.add(cou);
				}
			    request.getSession().setAttribute("allcourse", coulist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		else if(request.getParameter("type").equals("deletestudent"))
		{
			String del=((String)request.getParameter("no")).trim();
			try
			{
				String sql="delete from Qinjj_Student10 where qjj_Sno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,del);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "Ñ§Éú-"+del+"-É¾³ý³É¹¦");}
				else
				{request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		}
		else if(request.getParameter("type").equals("deleteteacher"))
		{
			String del=((String)request.getParameter("no")).trim();
			try
			{
				String sql="delete from Qinjj_Teacher10 where qjj_Tno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,del);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "½ÌÊ¦-"+del+"-É¾³ý³É¹¦");}
				else
				{request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		}
		else if(request.getParameter("type").equals("deletecourse"))
		{
			System.out.println("É¾³ý¿Î³Ì");
			String del=((String)request.getParameter("no")).trim();
			try
			{
				String sql="delete from Qinjj_Course10 where qjj_Cno10=?";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				pstmt.setString(1,del);
				if(pstmt.executeUpdate()==1)
				{request.getSession().setAttribute("error", "¿Î³Ì-"+del+"-É¾³ý³É¹¦");}
				else
				{request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		        pstmt.close();
		        dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();request.getSession().setAttribute("error", "É¾³ýÊ§°Ü");}
		}
		
		response.sendRedirect("admin.jsp");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		ArrayList<Teacher> tealist=new ArrayList<Teacher>();
		ArrayList<Course> coulist=new ArrayList<Course>();
		ArrayList<Student> stulist=new ArrayList<Student>();
		
		try
		{
			Connection dbconn=ds.getConnection();
			PreparedStatement pstmt;
			ResultSet rst;
			
			String sql="select * from Qinjj_Teacher10";
			pstmt=dbconn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Teacher tea=new Teacher(
						rst.getString("qjj_Tno10"), 
						rst.getString("qjj_Tname10"), 
						rst.getString("qjj_Tpass10"), 
						rst.getString("qjj_Ttitle10"), 
						rst.getString("qjj_Tsex10"), 
						rst.getInt("qjj_Tage10"), 
						rst.getString("qjj_Tphone10"));
				tealist.add(tea);
			}
			request.getSession().setAttribute("allteacher", tealist);
			
			sql="select * from Qinjj_Course10";
			pstmt=dbconn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Course cou=new Course(
						rst.getString("qjj_Cno10"),
						rst.getString("qjj_Cname10"),
						rst.getString("qjj_Cterm10"),
						rst.getString("qjj_Ctestway10"),
						rst.getInt("qjj_Ccredit10"),
						rst.getInt("qjj_Ctime10"));
				coulist.add(cou);
			}
		    request.getSession().setAttribute("allcourse", coulist);
		    
		    sql="select * from Qinjj_Student10";
			pstmt=dbconn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			while(rst.next())
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
				stulist.add(stu);
			}
			request.getSession().setAttribute("allstudent", stulist);
		    
			rst.close();
            pstmt.close();
            dbconn.close();
		}
		catch(SQLException e)
		{e.printStackTrace();}
		
		if(!request.getQueryString().isEmpty())
		{
			Student_Interface si=new Student_Interface();
			String str=request.getQueryString();
			if(str.equals("s1")){si.setcp("1");}
			else if(str.equals("s2")){si.setqg("1");}
			else if(str.equals("s3")){si.setcc("1");}
			else if(str.equals("s4")){si.setac("1");}
			else if(str.equals("s5")){si.seta1("1");}
			else if(str.equals("s6")){si.seta2("1");}
			request.getSession().setAttribute("student_interface", si);
		}
		
		response.sendRedirect("admin.jsp");
	}
}
