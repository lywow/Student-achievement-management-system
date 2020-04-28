<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>成绩查询系统-登录页</title>
	<link rel="stylesheet" href="css/auth.css">
            <% String mess=(String)session.getAttribute("error");
            if(mess!=null){%>
            <script type="text/javascript">alert("<%=mess%>");</script>
            <% }
            else{}session.removeAttribute("error");%>
</head>

<body>
	<div class="lowin">
		<div class="lowin-brand">
			<img src="kodinger.jpg" alt="logo">
		</div>
		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form action="login.do" method="post">
					<input type="hidden" name="type" value="student_login" />
						<p>欢迎您，同学</p>
						<div class="lowin-group">
							<label>学号 <a href="#" class="login-back-link"></a></label>
							<input type="text" autocomplete="username" name="username" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>密码 <a href="#" class="forgot-link"></a></label>
							<input type="password" name="password" autocomplete="current-password" class="lowin-input">
						</div>
						<input type="submit" value="登入" class="lowin-btn login-btn">

						<div class="text-foot">
							您是老师？<a href="" class="register-link">教师登录</a>
						</div>
						<div class="text-foot">
							您是管理员？<a href="alogin.jsp">管理员登录</a>
						</div>
					</form>
				</div>
			</div>

			<div class="lowin-box lowin-register">
				<div class="lowin-box-inner">
					<form action="login.do" method="post">
					<input type="hidden" name="type" value="teacher_login" />
						<p>欢迎您，老师</p>
						<div class="lowin-group">
							<label>账号</label>
							<input type="text" name="id" autocomplete="id" class="lowin-input">
						</div>
					
						<div class="lowin-group">
							<label>密码</label>
							<input type="password" name="password" autocomplete="current-password" class="lowin-input">
						</div>
						<input type="submit" value="登入" class="lowin-btn">

						<div class="text-foot">
							您是学生？<a href="" class="login-link">学生登录</a>
						</div>
						<div class="text-foot">
							您是管理员？<a href="alogin.jsp">管理员登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	
		<footer class="lowin-footer">
			<a href="#" target="_blank" title=""></a><a href="#" title="" target="_blank"></a>
		</footer>
	</div>

	<script src="js/auth.js"></script>
	<script>
		Auth.init({
			login_url: 'login.do',
			forgot_url: 'login.do'
		});
	</script>
</body>
</html>