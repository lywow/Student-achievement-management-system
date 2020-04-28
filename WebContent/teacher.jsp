<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="teacher" type="javabean.Teacher" scope="session"></jsp:useBean>
<%@ page import="java.util.*,javabean.*" %>
<html lang="ch">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="左右结构项目，属于大人员的社交工具">
        <meta name="keywords" content="左右结构项目 社交 占座 ">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>成绩查询系统-教师界面</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
  
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css" />
        <link rel="stylesheet" type="text/css" href="css/slide.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
    </head>

    <body>
        <div id="wrap">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="" src="images/logo.png"><span>成绩查询系统</span></p>
                </div>
                <div id="personInfor">
                    <table>
                    <tr><td>姓名:<jsp:getProperty name="teacher" property="name"/></td></tr>
                    <tr><td>工号:<jsp:getProperty name="teacher" property="no"/></td></tr>
                    <tr><td>职称:<jsp:getProperty name="teacher" property="title"/></td></tr>
                    <tr><td>年龄:<jsp:getProperty name="teacher" property="age"/></td></tr>
                    <tr><td>性别:<jsp:getProperty name="teacher" property="sex"/></td></tr>
                    <tr><td>电话:<jsp:getProperty name="teacher" property="phone"/></td></tr>
                    <tr><td><a href="exit.do">退出登录</a></td></tr>
                    </table>
                </div>
                <div class="meun-title">账号管理</div>
                <div class="meun-item">
                <a href="teacher.do?cp"><img src="images/icon_source.png">修改密码</a></div>
                <!-- <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">用户管理</div>
                <div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">修改密码</div> -->
                <div class="meun-title">课程相关</div>
                <div class="meun-item">
                <a href="teacher.do?mc"><img src="images/icon_house_grey.png">任课信息</a></div>
                <div class="meun-item">
                <a href="teacher.do?ac"><img src="images/icon_house_grey.png">所有课程</a></div>
                <!-- <div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">规则管理</div>
                <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>-->
                 <div class="meun-title">学生相关</div>
                <div class="meun-item">
                <a href="teacher.do?sq"><img src="images/icon_house_grey.png">学生查询</a></div>
                <!-- <div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">所有课程</div>
                <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>-->
            </div>
            <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
                             <!-- 修改密码模块 -->
             <% Student_Interface si=(Student_Interface)session.getAttribute("student_interface"); 
             if(si==null){si=new Student_Interface();}
             %>
            <div role="tabpanel" class="tab-pane" id="chan" style="display:<%=si.getcp()%>">
            <% String mess=(String)session.getAttribute("error");
            if(mess!=null){%>
            <script type="text/javascript">alert("<%=mess%>");</script>
            <% }
            else{}session.removeAttribute("error");%>
                <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
                    <form class="form-horizontal" action="changepass.do" method="post">
                        <input type="hidden" name="type" value="teacher_pass" />
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">原密码：</label>
                            <div class="col-xs-5">
                                <input type="password" class="form-control input-sm duiqi" id="sKnot" name="oldpass" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">新密码：</label>
                            <div class="col-xs-5">
                                <input type="password" class="form-control input-sm duiqi" id="sKnot" name="newpass" placeholder="" style="margin-top: 7px;">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
                            <div class="col-xs-5">
                                <input type="password" class="form-control input-sm duiqi" id="sKnot" name="toopass" placeholder="" style="margin-top: 7px;">
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
            <!--全部课程模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getcc() %>">
                <div class="check-div form-inline">
                    <form action="teacher.do" method="post">
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
                        <div class="col-xs-1 ">
                              开课班级
                        </div>
                        <div class="col-xs-1 ">
                              课程编号
                        </div>
                        <div class="col-xs-2">
                            授课教师
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
                    </div>
                    <div class="tablebody">
                        <% 
                        if(!((ArrayList<Class_Cou_Tea>)session.getAttribute("allcourse")).isEmpty())
                        {ArrayList<Class_Cou_Tea> acctlist=(ArrayList<Class_Cou_Tea>)session.getAttribute("allcourse");
                        	for(Class_Cou_Tea acct:acctlist){%>
                        <div class="row">
                            <div class="col-xs-1">
                                <%=acct.getClassno() %>
                            </div>
                            <div class="col-xs-1">
                                <%=acct.getCno() %>
                            </div>
                            <div class="col-xs-2">
                               <%=acct.getTname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=acct.getCname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=acct.getCterm() %>
                            </div>
                            <div class="col-xs-2">
                                <%=acct.getCtestway() %>
                            </div>
                            <div class="col-xs-1">
                                <%=acct.getCcredit() %>
                            </div>
                            <div class="col-xs-1">
                                <%=acct.getCtime() %>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
                       <!--全部学生模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getac() %>">
                <div class="check-div form-inline">
                    <form action="teacher.do" method="post">
                    <input type="hidden" name="type" value="alonesno"/>
                    <div class="col-xs-2"></div>
                    <div class="col-xs-4">
                        <input type="text" name="sno" class="form-control input-sm" placeholder="输入学号搜索">
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    </form>
                    <form action="teacher.do" method="post">
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
                        <div class="col-xs-2 ">
                              姓名
                        </div>
                        <div class="col-xs-2">
                            班级
                        </div>
                        <div class="col-xs-2">
                            性别
                        </div>
                        <div class="col-xs-2">
                            年龄
                        </div>
                        <div class="col-xs-2">
                            生源地
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
                            <div class="col-xs-2">
                                <%=stu.getname() %>
                            </div>
                            <div class="col-xs-2">
                               <%=stu.getclassno() %>
                            </div>
                            <div class="col-xs-2">
                                <%=stu.getsex() %>
                            </div>
                            <div class="col-xs-2">
                                <%=stu.getage() %>
                            </div>
                            <div class="col-xs-2">
                                <%=stu.getplace() %>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
            <!--任课情况模块-->
            <div role="tabpanel" class="tab-pane" id="stud" style="display:<%=si.getqg()%>">
                <div class="check-div form-inline">
                    <!-- <div class="col-xs-5">
                        <input type="text" class=" form-control input-sm" placeholder="输入课程编号搜索" style="	!height: 40px!important;">
                        <button type="submit" class="btn btn-white btn-xs ">查 询 </button>
                    </div>
                    <div class="col-xs-4 col-lg-4  col-md-5" style="padding-right: 40px;text-align: right;float: right;">
                    </div> -->

                </div>
                <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                            课程编号
                        </div>
                        <div class="col-xs-2 ">
                            课程名称
                        </div>
                        <div class="col-xs-2">
                            班级
                        </div>
                        <div class="col-xs-2">
                            学生数量
                        </div>
                        <div class="col-xs-2 ">
                            平均分
                        </div>
                        <div class="col-xs-2">
                            操作
                        </div>
                    </div>
                    <div class="tablebody">
                     <% int ab=0;
                        if(!((ArrayList<Teacher_Course>)session.getAttribute("mycourse")).isEmpty())
                        {ArrayList<Teacher_Course> mclist=(ArrayList<Teacher_Course>)session.getAttribute("mycourse");
                        	for(Teacher_Course mc:mclist){ %>
                        <div class="row">
                            <div class="col-xs-2 ">
                                <%=mc.getCno() %>
                            </div>
                            <div class="col-xs-2">
                                  <%=mc.getCname() %>
                            </div>
                            <div class="col-xs-2">
                                  <%=mc.getClassno() %>
                            </div>
                            <div class="col-xs-2">
                                 <%=mc.getcount() %>
                            </div>
                            <div class="col-xs-2">
                                  <%=mc.getavg() %>
                            </div>
                            <div class="col-xs-2">
                            <form action="teacher.do" method="post">
                            <input type="hidden" name="type" value="chan"/>
                            <input type="hidden" name="type1" value="grade"/>
                            <input type="hidden" name="noo" value="<%=ab %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">分数查询</button>
                            </form>
                           <form action="teacher.do" method="post">
                            <input type="hidden" name="type" value="chan"/>
                            <input type="hidden" name="type1" value="gradeing"/>
                             <input type="hidden" name="noo" value="<%=ab %>"/>
                                <button type="submit" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteObey">分数录入</button>
                            </form>
                            </div>
                        </div>
                        <%ab++; } }%>
                    </div>
                </div>
            </div>
            
            
        </div>
</div>
</body>

</html>