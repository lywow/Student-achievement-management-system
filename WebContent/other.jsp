<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,javabean.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩查询系统-操作</title>
            <% String mess=(String)session.getAttribute("error");
            if(mess!=null){%>
            <script type="text/javascript">alert("<%=mess%>");</script>
            <% }
            else{}session.removeAttribute("error");%>
</head>
<body>

<% 
ArrayList<String> inte=(ArrayList<String>)session.getAttribute("inte"); 
if(inte.get(0).equals("1"))
{Student stu=(Student)session.getAttribute("gggg");
%>

<!-- 修改学生信息 -->
<div style="display:<%=inte.get(0) %>>">
 <form action="other.do" method="post">
 <input type="hidden" name="type" value="ch_student">
 <input type="hidden" name="credit" value="<%=stu.getcredit() %>">
 <input type="hidden" name="noing" value="<%=stu.getno() %>">
  <table align="center" border="1">
    <tr><td align="center" colspan="3">修改学生信息</td></tr>
      <tr><td>学号</td><td><%=stu.getno() %></td><td><input type="text" name="sno" maxlength="12"></td></tr>
      <tr><td>密码</td><td><%=stu.getpass() %></td><td><input type="text" name="pass" maxlength="12"></td></tr>
      <tr><td>班级</td><td><%=stu.getclassno() %></td><td><input type="text" name="classno" maxlength="20"></td></tr>
      <tr><td>名字</td><td><%=stu.getname() %></td><td><input type="text" name="sname" maxlength="12"></td></tr>
      <tr><td>年龄</td><td><%=stu.getage() %></td><td><input type="text" name="age" maxlength="12"></td></tr>
      <tr><td>性别</td><td><%=stu.getsex() %></td><td>
        <select name="sex">
                           <option value="男">男</option>
                            <option value="女">女</option>
        </select></td>
      <tr><td>籍贯</td><td><%=stu.getplace() %></td><td>
        <select name="place">
                           <option value="广西">广西</option>
                            <option value="浙江">浙江</option>
                            <option value="上海">上海</option>
                            <option value="广东">广东</option>
                            <option value="四川">四川</option>
                            <option value="重庆">重庆</option>
                            <option value="北京">北京</option>
                            <option value="河南">河南</option>
                            <option value="湖南">湖南</option>
                            <option value="福建">福建</option>
                            <option value="江苏">江苏</option>
                            <option value="天津">天津</option>
        </select></td>
      </tr>
      <tr><td colspan="3" align="center"><input type="submit" name="submit" value="提交"></td></tr>
      <tr><td colspan="3" align="center"><a href="admin.do?01">返回</a></td></tr>
  </table>
 </form>
</div>

<%} if(inte.get(1).equals("1")){Teacher tea=(Teacher)session.getAttribute("gggg");%>

<!-- 修改教师信息 -->
<div style="display:<%=inte.get(1) %>">
 <form action="other.do" method="post">
  <input type="hidden" name="type" value="ch_teacher">
   <input type="hidden" name="noing" value="<%=tea.getno() %>">
  <table align="center" border="1">
    <tr><td align="center" colspan="3">修改教师信息</td></tr>
      <tr><td>工号</td><td><%=tea.getno() %></td><td><input type="text" name="tno"></td></tr>
      <tr><td>密码</td><td><%=tea.getpass() %></td><td><input type="text" name="pass"></td></tr>
      <tr><td>姓名</td><td><%=tea.getname() %></td><td><input type="text" name="tname"></td></tr>
      <tr><td>职称</td><td><%=tea.gettitle() %></td><td><input type="text" name="title"></td></tr>
      <tr><td>年龄</td><td><%=tea.getage() %></td><td><input type="text" name="age"></td></tr>
      <tr><td>电话</td><td><%=tea.getphone() %></td><td><input type="text" name="phone"></td></tr>
      <tr><td>性别</td><td><%=tea.getsex() %></td><td>
        <select name="sex">
                           <option value="男">男</option>
                            <option value="女">女</option>
        </select></td>
      <tr><td colspan="3" align="center"><input type="submit" name="submit" value="提交"></td></tr>
      <tr><td colspan="3" align="center"><a href="admin.do?01">返回</a></td></tr>
  </table>
 </form>
</div>

<% }if(inte.get(2).equals("1")){Course cou=(Course)session.getAttribute("gggg"); %>

<!-- 修改课程信息 -->
<div style="display:<%=inte.get(2) %>">
 <form action="other.do" method="post">
  <input type="hidden" name="type" value="ch_course">
   <input type="hidden" name="noing" value="<%=cou.getCno() %>">
  <table align="center" border="1">
    <tr><td align="center" colspan="3">修改课程信息</td></tr>
      <tr><td>编号</td><td><%=cou.getCno() %></td><td><input type="text" name="cno"></td></tr>
      <tr><td>名称</td><td><%=cou.getCname() %></td><td><input type="text" name="cname"></td></tr>
      <tr><td>学时</td><td><%=cou.getCtime() %></td><td><input type="text" name="time"></td></tr>
      <tr><td>学分</td><td><%=cou.getCcredit() %></td><td><input type="text" name="credit"></td></tr>
      <tr><td>学期</td><td><%=cou.getCterm() %></td><td>
        <select name="term">
                            <option value="2016/2017(1)">2016/2017(1)</option>
                            <option value="2016/2017(2)">2016/2017(2)</option>
                            <option value="2017/2018(1)">2017/2018(1)</option>
                            <option value="2017/2018(2)">2017/2018(2)</option>
                            <option value="2018/2019(1)">2018/2019(1)</option>
                            <option value="2018/2019(2)">2018/2019(2)</option>
                            <option value="2019/2020(1)">2019/2020(1)</option>
                            <option value="2019/2020(2)">2019/2020(2)</option>
        </select></td>
      <tr><td>考核</td><td><%=cou.getCtestway() %></td><td>
        <select name="way">
                           <option value="考试">考试</option>
                            <option value="考查">考查</option>
        </select></td>
      <tr><td colspan="3" align="center"><input type="submit" name="submit" value="提交"></td></tr>
      <tr><td colspan="3" align="center"><a href="admin.do?01">返回</a></td></tr>
  </table>
 </form>
</div>

<% } if(inte.get(3).equals("1")){ArrayList<Student_Grade> sglist=(ArrayList<Student_Grade>)session.getAttribute("gggg"); %>

<!-- 成绩排序 -->
<div>
<div style="display:<%=inte.get(3) %>">
 <form action="other.do" method="post">
  <table align="center" border="1">
    <tr><td align="center" colspan="3">该课成绩排序（仅显示已有成绩学生）</td></tr>
    <tr><td>学&nbsp;&nbsp;&nbsp;&nbsp;号</td><td>分&nbsp;数</td></tr>
    <%for(Student_Grade sg:sglist) {%>
	<tr><td><%=sg.getSno() %></td><td><%=sg.getGrade() %></td></tr>
	<%} %>
      <tr><td colspan="2" align="center"><a href="teacher.do?01">返回</a></td></tr>
  </table>
 </form>
</div>
</div>

<%} if(inte.get(4).equals("1")){ArrayList<Student_Grade> sglist1=(ArrayList<Student_Grade>)session.getAttribute("gggg");%>

<!-- 录入成绩 -->
<div>
<div style="display:<%=inte.get(4) %>">
 <form action="other.do" method="post">
 <input type="hidden" name="type" value="ch_grade">
  <table align="center" border="1">
    <tr><td align="center" colspan="2">录入成绩</td></tr>
    <tr><td>学号</td><td>分数</td></tr>
    <% for(Student_Grade sg1:sglist1) {%>
	<tr><td><%=sg1.getSno() %></td><td><input type="text" name="<%=sg1.getSno() %>" value="0"></td></tr>
	<% } %>
      <tr><td colspan="2" align="center"><input type="submit" name="submit" value="提交"></td></tr>
      <tr><td colspan="2" align="center"><a href=teacher.do?01">返回</a></td></tr>
  </table>
 </form>
</div>
</div>

<%} %>

</body>
</html>