package javabean;

import java.io.Serializable;

public class Student_Grade implements Serializable{
	private String Sno;
	private String Cno;
	private String Cname;
	private String Cterm;
	private String Tno;
	private int Grade;
	private String Tname;
	
	public Student_Grade()
	{}
	public Student_Grade(String s1,String s2,String s3,String s4,int i,String s5)
	{Sno=s1;Cno=s2;Cname=s3;Cterm=s4;Grade=i;Tname=s5;}
	
	public String getSno(){return Sno;}
	public String getCno(){return Cno;}
	public String getCname(){return Cname;}
	public String getCterm(){return Cterm;}
	public int getGrade(){return Grade;}
	public String getTname(){return Tname;}
	public String getTno(){return Tno;}
	
	public void setSno(String str){Sno=str;}
	public void setCno(String str){Cno=str;}
	public void setCname(String str){Cname=str;}
	public void setCterm(String str){Cterm=str;}
	public void setGrade(int i){Grade=i;}
	public void setTname(String str){Tname=str;}
	public void setTno(String str){Tno=str;}
}
