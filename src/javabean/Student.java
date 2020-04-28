package javabean;
import java.io.Serializable;

public class Student implements Serializable{
	private String no;
	private String name;
	private String pass;
	private String classno;
	private String sex;
	private int age;
	private int credit;
	private String place;
	
	public Student(){}
	public Student(String Sno,String Sname,String Spass,String Classno,String Ssex,int Sage,int Scre,String Splace)
	{no=Sno;name=Sname;pass=Spass;classno=Classno;sex=Ssex;age=Sage;credit=Scre;place=Splace;}
	
	public String getno(){return no;}
	public String getname(){return name;}
	public String getpass(){return pass;}
	public String getclassno(){return classno;}
	public String getsex(){return sex;}
	public String getplace(){return place;}
	public int getage(){return age;}
	public int getcredit(){return credit;}
	
	public void setno(String str){no=str;}
	public void setname(String str){name=str;}
	public void setpass(String str){pass=str;}
	public void setsex(String str){sex=str;}
	public void setclassno(String str){classno=str;}
	public void setplace(String str){place=str;}
	public void setage(int i){age=i;}
	public void setcreidt(int i){credit=i;}
}
