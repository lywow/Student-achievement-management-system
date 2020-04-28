<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,javabean.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="左右结构项目，属于大人员的社交工具">
<meta name="keywords" content="左右结构项目 社交 占座 ">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>成绩查询系统-管理员界面</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/slide.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
            <% String mess=(String)session.getAttribute("error");
            if(mess!=null){%>
            <script type="text/javascript">alert("<%=mess%>");</script>
            <% }
            else{}session.removeAttribute("error");%>
</head>

    <body>
        <div id="wrap">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="左右结构项目" src="images/logo.png"><span>成绩查询系统</span></p>
                </div>
                <div id="personInfor">
                    <p id="userName">欢迎</p>
                    <p><span>这里是</span>管理员界面s</p>
                    <p>
                        <a href="exit.do">退出登录</a>
                    </p>
                </div>
                <div class="meun-title">学生管理</div>
                <div class="meun-item">
                <a href="admin.do?s1"><img src="images/icon_source.png">学生查询</a></div>
                <div class="meun-item">
                <a href="admin.do?s2"><img src="images/icon_source.png">新增学生</a></div>
                <!-- <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">用户管理</div>
                <div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">修改密码</div> -->
                <div class="meun-title">教师管理</div>
                <div class="meun-item">
                <a href="admin.do?s3"><img src="images/icon_house_grey.png">教师查询</a></div>
                <div class="meun-item">
                <a href="admin.do?s4"><img src="images/icon_source.png">新增教师</a></div>
                <!-- <div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">规则管理</div>
                <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>-->
                 <div class="meun-title">课程管理</div>
                <div class="meun-item">
                <a href="admin.do?s5"><img src="images/icon_house_grey.png">课程查询</a></div>
                <div class="meun-item">
                <a href="admin.do?s6"><img src="images/icon_source.png">新增课程</a></div>
                <!--<div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">所有课程</div>
                 <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>-->
            </div>
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
                        <!-- 新增学生模块 -->
             <% Student_Interface si=(Student_Interface)session.getAttribute("student_interface"); 
             if(si==null){si=new Student_Interface();}
             %>
            <div role="tabpanel" class="tab-pane" id="chan" style="display:<%=si.getqg()%>">
                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    <form class="form-horizontal" action="admin.do" method="post">
                        <input type="hidden" name="type" value="add_student" />
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">新增学生提交表</label>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">学号：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="sno" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">姓名：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="sname" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">班级：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="classno" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">年龄：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="age" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">籍贯：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="place" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">性别：</label>
                            <div class="col-xs-5">
                                <select class=" form-control" name="sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-group text-right">
                            <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                <button type="reset" class="btn btn-xs btn-white">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green">保 存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
             <!-- 新增教师模块 -->
            <div role="tabpanel" class="tab-pane" id="chan" style="display:<%=si.getac()%>">
                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    <form class="form-horizontal" action="admin.do" method="post">
                        <input type="hidden" name="type" value="add_teacher" />
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">新增教师提交表</label>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">工号：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="tno" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">姓名：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="tname" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">职称：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="title" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">年龄：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="age" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">电话：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="phone" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">性别：</label>
                            <div class="col-xs-5">
                                <select class=" form-control" name="sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-group text-right">
                            <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                <button type="reset" class="btn btn-xs btn-white">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green">保 存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
             <!-- 新增课程模块 -->
            <div role="tabpanel" class="tab-pane" id="chan" style="display:<%=si.geta2() %>">
                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    <form class="form-horizontal" action="admin.do" method="post">
                        <input type="hidden" name="type" value="add_course" />
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">新增课程提交表</label>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">编号：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="cno" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">名称：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="cname" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">开课学期：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="term" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">学时：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="time" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">学分：</label>
                            <div class="col-xs-5">
                                <input type="text" class="form-control input-sm duiqi" id="sKnot" name="credit" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">考查方式：</label>
                            <div class="col-xs-5">
                                <select class=" form-control" name="way">
                            <option value="考试">考试</option>
                            <option value="考查">考查</option>
                            </select>
                            </div>
                        </div>
                        <div class="form-group text-right">
                            <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                                <button type="reset" class="btn btn-xs btn-white">取 消</button>
                                <button type="submit" class="btn btn-xs btn-green">保 存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!--全部学生模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getcp() %>">
                <div class="check-div form-inline">
                    <form action="admin.do" method="post">
                    <input type="hidden" name="type" value="alonesno"/>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-4">
                        <input type="text" name="sno" class="form-control input-sm" placeholder="输入学号搜索">
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    </form>
                    <form action="admin.do" method="post">
                    <input type="hidden" name="type" value="aloneplace"/>
                    <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                    <label for="paixu">生源地:&nbsp;</label>
                        <select name="place" class=" form-control">
                           <option value="all">全国</option>
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
                        </select></div>
                        <button type="submit" class="btn btn-white btn-xs ">确 定 </button>
                    </form>
                </div>
                <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                              学号
                        </div>
                        <div class="col-xs-1 ">
                              姓名
                        </div>
                        <div class="col-xs-2 ">
                              密码
                        </div>
                        <div class="col-xs-1">
                            班级
                        </div>
                        <div class="col-xs-1">
                            性别
                        </div>
                        <div class="col-xs-1">
                            年龄
                        </div>
                        <div class="col-xs-1">
                            生源地
                        </div>
                        <div class="col-xs-1">
                            学分
                        </div>
                        <div class="col-xs-2">
                            操作
                        </div>
                    </div>
                    <div class="tablebody">
                        <% 
                        if(!((ArrayList<Student>)session.getAttribute("allstudent")).isEmpty())
                        {ArrayList<Student> stulist=(ArrayList<Student>)session.getAttribute("allstudent");
                        	for(Student stu:stulist){%>
                        <div class="row">
                            <div class="col-xs-2">
                                <%=stu.getno() %>
                            </div>
                            <div class="col-xs-1">
                                <%=stu.getname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=stu.getpass() %>
                            </div>
                            <div class="col-xs-1">
                               <%=stu.getclassno() %>
                            </div>
                            <div class="col-xs-1">
                                <%=stu.getsex() %>
                            </div>
                            <div class="col-xs-1">
                                <%=stu.getage() %>
                            </div>
                            <div class="col-xs-1">
                                <%=stu.getplace() %>
                            </div>
                            <div class="col-xs-1">
                                <%=stu.getcredit() %>
                            </div>
                            <div class="col-xs-2">
                            <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="chan"/>
                            <input type="hidden" name="type1" value="student"/>
                            <input type="hidden" name="no" value="<%=stu.getno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">修改</button>
                            </form>
                            <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="deletestudent"/>
                            <input type="hidden" name="no" value="<%=stu.getno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">删除</button>
                            </form>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
          <!--全部教师模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getcc() %>">
                <div class="check-div form-inline">
                    <form action="admin.do" method="post">
                    <input type="hidden" name="type" value="alonetno"/>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-4">
                        <input type="text" name="tno" class="form-control input-sm" placeholder="输入工号搜索">
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    </form>
                </div>
                <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                              工号
                        </div>
                        <div class="col-xs-2 ">
                              密码
                        </div>
                        <div class="col-xs-1 ">
                              姓名
                        </div>
                        <div class="col-xs-1">
                            职称
                        </div>
                        <div class="col-xs-1">
                            性别
                        </div>
                        <div class="col-xs-1">
                            年龄
                        </div>
                        <div class="col-xs-2">
                            电话
                        </div>
                        <div class="col-xs-2">
                            操作
                        </div>
                    </div>
                    <div class="tablebody">
                        <% 
                        if(!((ArrayList<Teacher>)session.getAttribute("allteacher")).isEmpty())
                        {ArrayList<Teacher> tealist=(ArrayList<Teacher>)session.getAttribute("allteacher");
                        	for(Teacher tea:tealist){%>
                        <div class="row">
                            <div class="col-xs-2">
                                <%=tea.getno() %>
                            </div>
                            <div class="col-xs-2">
                                <%=tea.getpass() %>
                            </div>
                            <div class="col-xs-1">
                               <%=tea.getname() %>
                            </div>
                            <div class="col-xs-1">
                                <%=tea.gettitle() %>
                            </div>
                            <div class="col-xs-1">
                               <%=tea.getsex() %>
                            </div>
                            <div class="col-xs-1">
                                <%=tea.getage() %>
                            </div>
                            <div class="col-xs-2">
                                <%=tea.getphone() %>
                            </div>
                            <div class="col-xs-2">
                             <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="chan"/>
                            <input type="hidden" name="type1" value="teacher"/>
                            <input type="hidden" name="no" value="<%=tea.getno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">修改</button>
                            </form>
                            <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="deleteteacher"/>
                            <input type="hidden" name="no" value="<%=tea.getno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">删除</button>
                            </form>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
             <!--全部课程模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.geta1() %>">
                <div class="check-div form-inline">
                    <form action="admin.do" method="post">
                    <input type="hidden" name="type" value="alonecno"/>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-4">
                        <input type="text" name="cno" class="form-control input-sm" placeholder="输入编号搜索">
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    </form>
                    <form action="admin.do" method="post">
                    <input type="hidden" name="type" value="allcourse"/>
                    <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                        <label for="paixu">选择学期:&nbsp;</label>
                        <select class=" form-control" name="term">
                            <option value="all">全部</option>
                            <option value="2016/2017(1)">2016/2017(1)</option>
                            <option value="2016/2017(2)">2016/2017(2)</option>
                            <option value="2017/2018(1)">2017/2018(1)</option>
                            <option value="2017/2018(2)">2017/2018(2)</option>
                            <option value="2018/2019(1)">2018/2019(1)</option>
                            <option value="2018/2019(2)">2018/2019(2)</option>
                            <option value="2019/2020(1)">2019/2020(1)</option>
                            <option value="2019/2020(2)">2019/2020(2)</option>
                        </select>
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    </form>
                </div>
                <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                              课程编号
                        </div>
                        <div class="col-xs-2">
                            课程名称
                        </div>
                        <div class="col-xs-2">
                            开课学期
                        </div>
                        <div class="col-xs-2">
                            课程分数
                        </div>
                        <div class="col-xs-1">
                           学分
                        </div>
                        <div class="col-xs-1">
                           学时
                        </div>
                        <div class="col-xs-2">
                           操作
                        </div>
                    </div>
                    <div class="tablebody">
                        <% 
                        if(!((ArrayList<Course>)session.getAttribute("allcourse")).isEmpty())
                        {ArrayList<Course> coulist=(ArrayList<Course>)session.getAttribute("allcourse");
                        	for(Course cou:coulist){%>
                        <div class="row">
                            <div class="col-xs-2">
                                <%=cou.getCno() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cou.getCname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cou.getCterm() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cou.getCtestway() %>
                            </div>
                            <div class="col-xs-1">
                                <%=cou.getCcredit() %>
                            </div>
                            <div class="col-xs-1">
                                <%=cou.getCtime() %>
                            </div>
                            <div class="col-xs-2">
                            <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="chan"/>
                            <input type="hidden" name="type1" value="course"/>
                            <input type="hidden" name="no" value="<%=cou.getCno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">修改</button>
                            </form>
                            <form action="admin.do" method="post">
                            <input type="hidden" name="type" value="deletecourse"/>
                            <input type="hidden" name="no" value="<%=cou.getCno() %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">删除</button>
                            </form>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
            
            
            
        </div>
     </div>
</body>

</html>