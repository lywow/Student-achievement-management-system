package javabean;

import java.io.Serializable;

public class Student_Interface implements Serializable{
	private String cp;
	private String qg;
	private String cc;
	private String ac;
	private String a1;
	private String a2;
	
	public Student_Interface()
	{cp="none";qg="none";cc="none";ac="none";a1="none";a2="none";}
	public Student_Interface(String s1,String s2,String s3,String s4)
	{cp=s1;qg=s2;cc=s3;ac=s4;}
	public Student_Interface(String s1,String s2,String s3,String s4,String s5,String s6)
	{cp=s1;qg=s2;cc=s3;ac=s4;a1=s5;a2=s6;}
	
	public String getcp(){return cp;}
	public String getqg(){return qg;}
	public String getcc(){return cc;}
	public String getac(){return ac;}
	public String geta1(){return a1;}
	public String geta2(){return a2;}
	
	public void setcp(String str){cp=str;}
	public void setqg(String str){qg=str;}
	public void setcc(String str){cc=str;}
	public void setac(String str){ac=str;}
	public void seta1(String str){a1=str;}
	public void seta2(String str){a2=str;}
}