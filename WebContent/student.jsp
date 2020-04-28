<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="student" type="javabean.Student" scope="session"></jsp:useBean>
<%@ page import="java.util.*,javabean.*" %>

<html lang="ch">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>成绩查询系统-学生页面</title>
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
                    <tr><td id="logoP"><img id="logo" alt="成绩查询系统" src="images/logo.png"><span>成绩查询系统</span></p>
                </div>
                <div id="personInfor">
                    <table>
                    <tr><td>姓名:<jsp:getProperty name="student" property="name"/></td></tr>
                    <tr><td>学号:<jsp:getProperty name="student" property="no"/></td></tr>
                    <tr><td>班级:<jsp:getProperty name="student" property="classno"/></td></tr>
                    <tr><td>籍贯:<jsp:getProperty name="student" property="place"/></td></tr>
                    <tr><td>性别:<jsp:getProperty name="student" property="sex"/></td></tr>
                    <tr><td>学分:<jsp:getProperty name="student" property="credit"/></td></tr>
                    <tr><td><a href="exit.do">退出登录</a></td></tr>
                    </table>
                </div>
                <div class="meun-title">账号管理</div>
                <div class="meun-item">
                <a href="student.do?cp"><img src="images/icon_source.png">修改密码</a></div>
                <!-- <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">用户管理</div>
                <div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">修改密码</div> -->
                <div class="meun-title">成绩查询</div>
                <div class="meun-item">
                <a href="student.do?qg"><img src="images/icon_house_grey.png">我的成绩</a></div>
                <!-- <div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">规则管理</div>
                <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>-->
                <div class="meun-title">信息查询</div>
                <div class="meun-item">
                <a href="student.do?cc"><img src="images/icon_house_grey.png">班级课程</a></div>
                <div class="meun-item">
                <a href="student.do?ac"><img src="images/icon_rule_grey.png">所有课程</a></div>
                <!-- <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
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
                        <input type="hidden" name="type" value="student_pass" />
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

           <!--班级课程模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getcc() %>">
                <div class="check-div form-inline">
                    <form action="student.do" method="post">
                    <input type="hidden" name="type" value="classcourse"/>
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
                            授课教师
                        </div>
                        <div class="col-xs-2">
                            课程名称
                        </div>
                        <div class="col-xs-2">
                            开课学期
                        </div>
                        <div class="col-xs-2">
                            考核方式
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
                        if(!((ArrayList<Class_Cou_Tea>)session.getAttribute("classcourse")).isEmpty())
                        {ArrayList<Class_Cou_Tea> cctlist=(ArrayList<Class_Cou_Tea>)session.getAttribute("classcourse");
                        	for(Class_Cou_Tea cct:cctlist){%>
                        <div class="row">
                            <div class="col-xs-2 ">
                                <%=cct.getCno() %>
                            </div>
                            <div class="col-xs-2">
                               <%=cct.getTname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cct.getCname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cct.getCterm() %>
                            </div>
                            <div class="col-xs-2">
                                <%=cct.getCtestway() %>
                            </div>
                            <div class="col-xs-1">
                                <%=cct.getCcredit() %>
                            </div>
                            <div class="col-xs-1">
                                <%=cct.getCtime() %>
                            </div>
                         </div>
                            <%} }%>
                    </div>
                </div>
           </div>
           <!--全部课程模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getac() %>">
                <div class="check-div form-inline">
                    <form action="student.do" method="post">
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
                       <!--成绩查询模块-->
           <div role="tabpanel" class="tab-pane" id="user" style="display:<%=si.getqg() %>">
                <div class="check-div form-inline">
                    <form action="student.do" method="post">
                    <input type="hidden" name="type" value="querygrade"/>
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
                              学号
                        </div>
                        <div class="col-xs-2">
                            课程编码
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
                        <div class="col-xs-2">
                           授课教师
                        </div>
                    </div>
                    <div class="tablebody">
                        <%
                        if(!((ArrayList<Student_Grade>)session.getAttribute("querygrade")).isEmpty())
                        {ArrayList<Student_Grade> sglist=(ArrayList<Student_Grade>)session.getAttribute("querygrade");
                        	for(Student_Grade sg:sglist){%>
                        <div class="row">
                            <div class="col-xs-2 ">
                                <%=sg.getSno() %>
                            </div>
                            <div class="col-xs-2">
                               <%=sg.getCno() %>
                            </div>
                            <div class="col-xs-2">
                                <%=sg.getCname() %>
                            </div>
                            <div class="col-xs-2">
                                <%=sg.getCterm() %>
                            </div>
                            <div class="col-xs-2">
                                <%=sg.getGrade() %>
                            </div>
                            <div class="col-xs-2">
                                <%=sg.getTname() %>
                            </div>
                         </div>
                            <%}}%>
                    </div>
                </div>
           </div>
     </div>
</div>
</body>
</html>