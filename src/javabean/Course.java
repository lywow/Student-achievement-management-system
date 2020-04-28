package javabean;

import java.io.Serializable;

public class Course implements Serializable{
	private String Cno;
	private String Cname;
	private String Cterm;
	private String Ctestway;
	private int Ccredit;
	private int Ctime;
	
	
	public Course()
	{}
	public Course(String s4,String s5,String s6,String s7,int i1,int i2)
	{Cno=s4;Cname=s5;Cterm=s6;Ctestway=s7;Ccredit=i1;Ctime=i2;}
	

	public String getCno(){return Cno;}
	public String getCname(){return Cname;}
	public String getCterm(){return Cterm;}
	public String getCtestway(){return Ctestway;}
	public int getCcredit(){return Ccredit;}
	public int getCtime(){return Ctime;}

	
	public void setCno(String str){Cno=str;}
	public void setCname(String str){Cname=str;}
	public void setCterm(String str){Cterm=str;}
	public void setTname(String str){Cname=str;}
	public void setCtestway(String str){Cterm=str;}
	public void setCcredit(int i){Ccredit=i;}
	public void setCtime(int i){Ctime=i;}

}
