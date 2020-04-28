package javabean;

import java.io.Serializable;

public class Class_Cou_Tea implements Serializable{
	private String Tno;
	private String Classno;
	private String Tname;
	private String Cno;
	private String Cname;
	private String Cterm;
	private String Ctestway;
	private int Ccredit;
	private int Ctime;
	
	
	public Class_Cou_Tea()
	{}
	public Class_Cou_Tea(String s1,String s2,String s3,String s4,String s5,String s6,String s7,int i1,int i2)
	{Tno=s1;Classno=s2;Tname=s3;Cno=s4;Cname=s5;Cterm=s6;Ctestway=s7;Ccredit=i1;Ctime=i2;}
	
	public String getTno(){return Tno;}
	public String getCno(){return Cno;}
	public String getCname(){return Cname;}
	public String getCterm(){return Cterm;}
	public String getClassno(){return Classno;}
	public String getTname(){return Tname;}
	public String getCtestway(){return Ctestway;}
	public int getCcredit(){return Ccredit;}
	public int getCtime(){return Ctime;}

	
	public void setTno(String str){Tno=str;}
	public void setCno(String str){Cno=str;}
	public void setCname(String str){Cname=str;}
	public void setCterm(String str){Cterm=str;}
	public void setClassno(String str){Tname=str;}
	public void setTname(String str){Cname=str;}
	public void setCtestway(String str){Cterm=str;}
	public void setCcredit(int i){Ccredit=i;}
	public void setCtime(int i){Ctime=i;}

}