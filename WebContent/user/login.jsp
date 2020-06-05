<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="../ucss/login.css">
</head>
<body>
	<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="./index.html" target="_top"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="<%=path%>/user/User_userLogin.action" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">用户登录</div>
					<div class="right fr">您还不是我们的用户？<a href="register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">手机号:&nbsp;<input class="shurukuang" type="text" name="userPhone" placeholder="请输入你的账号"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/></div>
<!-- 					<div class="username"> -->
<!-- 						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div> -->
<!-- 						<div class="right fl"><img src="./image/yanzhengma.jpg"></div> -->
<!-- 						<div class="clear"></div> -->
<!-- 					</div> -->
				</div>
				<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="立即登录" >
				</div>
				
			</div>
		</div>
		</form>
</body>
</html>