package javabean;

import java.io.Serializable;

public class Alone_Grade implements Serializable{
	private String Cno;
	private String Tno;
	private String Sno;
	private String Sname;
	private String Classno;
	private int grade;
	
	public Alone_Grade(){}
	public Alone_Grade(String s1,String s2,String s3,String s4,String s5,int i)
	{Cno=s1;Tno=s2;Sno=s3;Sname=s4;grade=i;Classno=s5;}
	
	public String getCno(){return Cno;}
	public String getTno(){return Tno;}
	public String getSno(){return Sno;}
	public String getSname(){return Sname;}
	public String getClassno(){return Classno;}
	public int getgrade(){return grade;}
	
	public void setCno(String str){Cno=str;}
	public void setTno(String str){Tno=str;}
	public void setSno(String str){Sno=str;}
	public void setSname(String str){Sname=str;}
	public void setClassno(String str){Classno=str;}
	public void setCno(int i){grade=i;}
}
