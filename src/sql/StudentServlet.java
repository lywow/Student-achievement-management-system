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

import javabean.Class_Cou_Tea;
import javabean.Student;
import javabean.Student_Grade;
import javabean.Student_Interface;

@WebServlet("/student.do")
public class StudentServlet extends HttpServlet{
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
		if(request.getParameter("type").equals("querygrade"))
		{querygrade(request,response);}
		if(request.getParameter("type").equals("classcourse"))
		{classcourse(request,response);}
		if(request.getParameter("type").equals("allcourse"))
		{allcourse(request,response);}
		response.sendRedirect("student.jsp");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		Student stu=(Student)request.getSession().getAttribute("student");
		String no=stu.getno().trim();
		ArrayList<Student_Grade> sglist=new ArrayList<Student_Grade>();
		String classno=stu.getclassno().trim();
		ArrayList<Class_Cou_Tea> cctlist=new ArrayList<Class_Cou_Tea>();
		ArrayList<Class_Cou_Tea> acctlist=new ArrayList<Class_Cou_Tea>();
		
		try
		{
			String sql1="select * from Qinjj_stu_grade_view10 where qjj_Sno10=?";
			Connection dbconn=ds.getConnection();
			PreparedStatement pstmt=dbconn.prepareStatement(sql1);
			pstmt.setString(1,no);
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
		    request.getSession().setAttribute("querygrade", sglist);
			
			String sql2="select * from Qinjj_tea_cou_view10 where qjj_Classno10=?";
			pstmt=dbconn.prepareStatement(sql2);
			pstmt.setString(1,classno);
			rst=pstmt.executeQuery();
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
				cctlist.add(cct);
			}
			request.getSession().setAttribute("classcourse", cctlist);
			
			String sql3="select * from Qinjj_tea_cou_view10";
			pstmt=dbconn.prepareStatement(sql3);
			rst=pstmt.executeQuery();
			while(rst.next())
			{
				Class_Cou_Tea acct=new Class_Cou_Tea(
						rst.getString("qjj_Tno10"),
						rst.getString("qjj_Classno10"),
						rst.getString("qjj_Tname10"),
						rst.getString("qjj_Cno10"),
						rst.getString("qjj_Cname10"),
						rst.getString("qjj_Cterm10"),
						rst.getString("qjj_Ctestway10"),
						rst.getInt("qjj_Ccredit10"),
						rst.getInt("qjj_Ctime10"));
				acctlist.add(acct);
			}
		    request.getSession().setAttribute("allcourse", acctlist);
			
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
			if(str.equals("cp")){si.setcp("1");System.out.println("1111111111111");}
			else if(str.equals("qg")){si.setqg("1");System.out.println("222222222222222");}
			else if(str.equals("cc")){si.setcc("1");System.out.println("33333333333333333");}
			else if(str.equals("ac")){si.setac("1");System.out.println("444444444444444");}
			request.getSession().setAttribute("student_interface", si);
		}
		
		response.sendRedirect("student.jsp");
	}
	
	public void querygrade(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String term=request.getParameter("term");
		Student stu=(Student)request.getSession().getAttribute("student");
		String no=stu.getno().trim();
		ArrayList<Student_Grade> sglist=new ArrayList<Student_Grade>();
		
		try
		{
			String sql="select * from Qinjj_stu_grade_view10 where qjj_Sno10=?";
			Connection dbconn=ds.getConnection();
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1,no);
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
				if(term.equals("all"))
				{sglist.add(sg);}
				else if(term.equals(sg.getCterm()))
				{sglist.add(sg);}
			}
		    request.getSession().setAttribute("querygrade", sglist);
			rst.close();
            pstmt.close();
            dbconn.close();
		}
		catch(SQLException e)
		{e.printStackTrace();}
	}
	
	public void classcourse(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String term=request.getParameter("term");
		Student stu=(Student)request.getSession().getAttribute("student");
		String classno=stu.getclassno().trim();
		ArrayList<Class_Cou_Tea> cctlist=new ArrayList<Class_Cou_Tea>();
		
		try
		{
			String sql="select * from Qinjj_tea_cou_view10 where qjj_Classno10=?";
			Connection dbconn=ds.getConnection();
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			pstmt.setString(1,classno);
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
		    request.getSession().setAttribute("classcourse", cctlist);
			rst.close();
            pstmt.close();
            dbconn.close();
		}
		catch(SQLException e)
		{e.printStackTrace();}
	}
	public void allcourse(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
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
}