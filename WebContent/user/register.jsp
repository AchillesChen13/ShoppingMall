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
<link rel="stylesheet" type="text/css" href="../ucss/login.css">
<script type="text/javascript" src="../mjs/jquery-3.0.0.min.js"></script>
<title>用户注册</title>
</head>
<body>
	<form method="post" action="<%=path%>/user/User_userRegiste.action">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">用户注册</div>
					<div class="right fr">
						<a href="goods.jsp" target="_self">天天商城</a>
					</div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">
						手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input id="tel" class="shurukuang"
							type="text" name="userPhone" placeholder="请填写正确的手机号" onblur="checkInputTel();"/><span id="stel">填写下手机号，是你的登录账号哟！</span>
					</div>
					<div class="username">
						用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input id="name" class="shurukuang"
							type="text" name="userName" placeholder="请输入你的用户名" onblur="checkInputName();"/><span id="sname"></span>
					</div>
					<div class="username">
						密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input
							class="shurukuang" id="password" type="password" name="password"
							placeholder="请输入你的密码" /><span id="spw">请输入6位以上字符</span>
					</div>

					<div class="username">
						确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" id="repassword"
							name="repassword" placeholder="请确认你的密码" onblur="checkPw();"/><span id="srpw">两次密码要输入一致哦</span>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" onclick="return checkInput();" value="立即注册">
				</div>

			</div>
		</div>
	</form>
	
	<script type="text/javascript" src="../mjs/jquery-3.0.0.min.js"></script>
	<script type="text/javascript">
		var flag1=0,flag2=0,flag3=0;
		//检查电话
		function checkInputTel() {
			var uText2 = document.getElementById("tel").value;
			var label2 = document.getElementById("stel");
			if (uText2 == "") {
				alert("电话不能为空！");
				label2.style.color = "black";
				label2.innerText = "手机号不能为空!";
				flag1 = 0;
			} else {
				if (uText2.search(/^(\+86)?1\d{10}$/) != -1) {
					flag1 = 1;
					label2.innerText = "";
				} else {
					label2.style.color = "black";
					label2.innerText = "仅支持+86的手机号";
					alert("仅支持+86的手机号！");
					flag1 = 0;
				}
			}
		}
		
		
		function checkInputName() {
			var uText = document.getElementById("name").value;
			var label = document.getElementById("sname");
			if (uText==""){
				label.style.color = "black";
				label.innerText = "姓名不能为空！"; //显示提示信息
				flag2s=0;
			}
			else{
				flag2=1;
			}
		}
		
		function checkPw(){
			var pw = document.getElementById("password").value;
			var rpw = document.getElementById("repassword").value;
			var spw = document.getElementById("spw");
			var srpw = document.getElementById("srpw");
			if (pw.length<6){
				spw.style.color = "black";
				spw.innerText = "密码长度至少6位！"; //显示提示信息
			}
			else{
				if (pw!=rpw){
					srpw.style.color = "black";
					srpw.innerText = "两次密码不一致！"; //显示提示信息
				}
				else{
					flag3=1;
				}
			}
		}
		
		function checkInput(){
			if ((flag1!=0)&&(flag2!=0)&&(flag3!=0)){
				return true;
			}
			else{
				return false;
			}
		}
	</script>
</body>
</html>