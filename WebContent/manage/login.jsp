<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>超管理登录</title>
<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../mjs/jquery.js"></script>
<script src="../mjs/cloud.js" type="text/javascript"></script>
<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>
</head>
<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="../user/goods.jsp">回首页</a></li>
		</ul>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox">

			<form action="<%=path%>/manage/Supermarket_supLogin.action" method="post">
				<ul>
					<li><input name="supName" type="text" class="loginuser" /></li>
					<li><input name="supPassword" type="password" class="loginpwd"/></li>
					<li>
						<input name="" type="submit" class="loginbtn" value="登录"/>
						<input name="" type="reset" class="loginbtn" value="重置"/>
					</li>
				</ul>
				<div>
    				<s:fielderror/>
				</div>
			</form>
			
		</div>

	</div>
</body>
</html>