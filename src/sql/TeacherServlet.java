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
import javabean.Student;
import javabean.Student_Grade;
import javabean.Student_Interface;
import javabean.Teacher;
import javabean.Teacher_Course;

@WebServlet("/teacher.do")
public class TeacherServlet extends HttpServlet{
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
			
			String noo=request.getParameter("noo");
			
			if(request.getParameter("type1").equals("grade"))
			{inte.set(3, "1");}
			if(request.getParameter("type1").equals("gradeing"))
			{inte.set(4, "1");}
			
			System.out.println(inte.get(3)+"  -----------  "+inte.get(4)+"  -----------  "+noo);
			
			request.getSession().setAttribute("inte", inte);
			request.getSession().setAttribute("noo", noo);
			response.sendRedirect("other.do");
			return;
		}
		
		if(request.getParameter("type").equals("allcourse"))
		{
			String term=request.getParameter("term");
			ArrayList<Class_Cou_Tea> cctlist=new ArrayList<Class_Cou_Tea>();
			try
			{
				String sql="select * from Qinjj_tea_cou_view10";
				Connection dbconn=ds.getConnection();
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				ResultSet rst=pstmt.executeQuery();
				
				while(rst.next())
				{
					Class_Cou_Tea cct=new Class_Cou_Tea(
							rst.getString("qjj_Tno10"),
							rst.getString("qjj_Classno10"),
							rst.getString("qjj_Tname10"),
							rst.getString("qjj_Cno10"),
							rst.getString("qjj_Cname10"),
							rst.getString("qjj_Cterm10"),
							rst.getString("qjj_Ctestway10"),
							rst.getInt("qjj_Ccredit10"),
							rst.getInt("qjj_Ctime10"));
					if(term.equals("all"))
					{cctlist.add(cct);}
					else if(term.equals(cct.getCterm()))
					{cctlist.add(cct);}
				}
			    request.getSession().setAttribute("allcourse", cctlist);
				rst.close();
	            pstmt.close();
	            dbconn.close();
			}
			catch(SQLException e)
			{e.printStackTrace();}
		}
		if(request.getParameter("type").equals("alonesno"))
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
		if(request.getParameter("type").equals("aloneplace"))
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
		
		response.sendRedirect("teacher.jsp");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Teacher tea=(Teacher)request.getSession().getAttribute("teacher");
		String no=tea.getno().trim();
		ArrayList<Teacher_Course> mctlist=new ArrayList<Teacher_Course>();
		ArrayList<Class_Cou_Tea> actlist=new ArrayList<Class_Cou_Tea>();
		ArrayList<Student> stulist=new ArrayList<Student>();
		
		try
		{
			Connection dbconn=ds.getConnection();
			PreparedStatement pstmt;
			ResultSet rst;
			
			String sql="select Qinjj_tea_cou_view10.*,Qinjj_class_count_view10.qjj_count_stu10 "
					+ "from Qinjj_tea_cou_view10,Qinjj_class_count_view10 "
					+ "where Qinjj_tea_cou_view10.qjj_Classno10=Qinjj_class_count_view10.qjj_Classno10 and qjj_Tno10=?";
			pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1,no);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Teacher_Course cct=new Teacher_Course(
						rst.getString("qjj_Tno10"),
						rst.getString("qjj_Cno10"),
						rst.getString("qjj_Cname10"),
						rst.getString("qjj_Classno10"),
						0,
						rst.getInt("qjj_count_stu10"));
				String sql1="select * from Qinjj_class_avg_view10 where qjj_Tno10=? and qjj_Cno10=? and qjj_Classno10=?";
				PreparedStatement pstmt1=dbconn.prepareStatement(sql1);
				pstmt1.setString(1,no);
				pstmt1.setString(2,cct.getCno());
				pstmt1.setString(3,cct.getClassno());
				ResultSet rst1=pstmt1.executeQuery();
				if(rst1.next())
				{cct.setavg(rst1.getInt("qjj_avg_grade10"));}
				rst1.close();pstmt1.close();
				mctlist.add(cct);
			}
			request.getSession().setAttribute("mycourse", mctlist);
			
			sql="select * from Qinjj_tea_cou_view10";
			pstmt=dbconn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Class_Cou_Tea act=new Class_Cou_Tea(
						rst.getString("qjj_Tno10"),
						rst.getString("qjj_Classno10"),
						rst.getString("qjj_Tname10"),
						rst.getString("qjj_Cno10"),
						rst.getString("qjj_Cname10"),
						rst.getString("qjj_Cterm10"),
						rst.getString("qjj_Ctestway10"),
						rst.getInt("qjj_Ccredit10"),
						rst.getInt("qjj_Ctime10"));
				actlist.add(act);
			}
		    request.getSession().setAttribute("allcourse", actlist);
		    
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
			if(str.equals("cp")){si.setcp("1");}
			else if(str.equals("mc")){si.setqg("1");}
			else if(str.equals("ac")){si.setcc("1");}
			else if(str.equals("sq")){si.setac("1");}
			request.getSession().setAttribute("student_interface", si);
		}
		
		response.sendRedirect("teacher.jsp");
	}
}
