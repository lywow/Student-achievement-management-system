<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>成绩查询系统-管理员登录页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="js/bootstrap-responsive.css" rel="stylesheet">
            <% String mess=(String)session.getAttribute("error");
            if(mess!=null){%>
            <script type="text/javascript">alert("<%=mess%>");</script>
            <% }
            else{}session.removeAttribute("error");%>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="login.do" method="post">
      <input type="hidden" name="type" value="admin_login" />
        <h2 class="form-signin-heading">欢迎你，管理员</h2>
        <input type="text" name="id" class="input-block-level" placeholder="账号">
        <input type="password" name="password" class="input-block-level" placeholder="通行证">
       
        <button class="btn btn-large btn-primary" type="submit">登 入</button>
        <button class="btn btn-large btn-primary" href="index.jsp">返 回</button>
      </form>
    </div>
</body></html>