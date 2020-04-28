package javabean;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String no;
	private String name;
	private String pass;
	private String title;
	private String sex;
	private int age;
	private String phone;
	
	public Teacher(){}
	public Teacher(String Tno,String Tname,String Tpass,String Ttitle,String Tsex,int Tage,String Tphone)
	{no=Tno;name=Tname;pass=Tpass;sex=Tsex;age=Tage;phone=Tphone;title=Ttitle;}
	
	public String getno(){return no;}
	public String getname(){return name;}
	public String getpass(){return pass;}
	public String gettitle(){return title;}
	public String getsex(){return sex;}
	public String getphone(){return phone;}
	public int getage(){return age;}
	
	public void setno(String str){no=str;}
	public void setname(String str){name=str;}
	public void setpass(String str){pass=str;}
	public void setsex(String str){sex=str;}
	public void settitle(String str){title=str;}
	public void setplace(String str){phone=str;}
	public void setage(int i){age=i;}
}
