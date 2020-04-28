package javabean;

import java.io.Serializable;

public class Teacher_Course implements Serializable{
	private String Tno;
	private String Cname;
	private String Cno;
	private String Classno;
	private int avg;
	private int count;
	
	public Teacher_Course(){}
	public Teacher_Course(String s1,String s2,String s3,String s4,int i1,int i2)
	{Tno=s1;Cno=s2;Cname=s3;Classno=s4;avg=i1;count=i2;}
	
	public String getTno(){return Tno;}
	public String getCname(){return Cname;}
	public String getCno(){return Cno;}
	public String getClassno(){return Classno;}
	public int getavg(){return avg;}
	public int getcount(){return count;}
	
	public void setTno(String str){Tno=str;}
	public void setCname(String str){Cname=str;}
	public void setCno(String str){Cno=str;}
	public void setClassno(String str){Classno=str;}
	public void setavg(int i){avg=i;}
	public void setcountt(int i){count=i;}
}