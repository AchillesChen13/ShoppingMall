<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>地址管理</title>
<link href="../ucss/amazeui.css" rel="stylesheet" type="text/css">

<link href="../ucss/personal.css" rel="stylesheet" type="text/css">
<link href="../ucss/addstyle.css" rel="stylesheet" type="text/css">
<script src="../mjs/jquery.min.js" type="text/javascript"></script>
<script src="../mjs/amazeui.js" type="text/javascript"></script>
<body>
	<!--头 -->
	<header> 
	<article>
	<div class="mt-logo">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="login.jsp" target="_top" class="h">欢迎~<span>${sessionScope.loginUser.userName}</span>~亲，登录</a> <a
							href="register.jsp" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="../index.jsp" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="gouwuche.jsp" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h">0</strong></a>
					</div>
				</div>
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="clear"></div>
	</div>
	</div>
	</article> 
</header>

	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">地址信息</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="../index.jsp" target="_top">首页</a></li>
				<li class="index"><a href="<%=path%>/user/Order_queryAllOrder.action" target="_top">订单</a></li>
				<li class="index"><a href="#" target="_top">购物车</a></li>
			</ul>
		</div>
	</div>
	<b class="line"></b>

	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-address">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small>
						</div>
					</div>
					<hr />
					<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">

						<s:iterator value="#session.addrlist" var="address" status="st">
							<s:if test="#st.isFirst()">
							<li class="user-addresslist defaultAddr">
							<span class="new-option-r" id="ddfaulit"><i class="am-icon-check-circle"></i>默认地址</span>
								<p class="new-tit new-p-re">
									<span class="title">收货人姓名：</span> <span class="new-txt-rd2"><s:property
											value="#address.name" /></span> <br> <span class="title">收货人电话：</span>
									<span class="new-txt-rd2"><s:property
											value="#address.phone" /></span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">&nbsp;&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;：</span>
										<span class="new-txt-rd2"><s:property
												value="#address.address" /> </span>
									</p>
								</div>
								<div class="new-addr-btn">
									<span
										class="new-addr-bar">|</span> <a href="<%=path%>/user/Address_deleteAddress?addressNo=<s:property
												value="#address.addressNo"/>"><i class="am-icon-trash"></i>删除</a>
								</div></li>
								</s:if>
								<s:if test="#st.index>0">
									<li class="user-addresslist">
							<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
								<p class="new-tit new-p-re">
									<span class="title">收货人姓名：</span> <span class="new-txt-rd2"><s:property
											value="#address.name" /></span> <br> <span class="title">收货人电话：</span>
									<span class="new-txt-rd2"><s:property
											value="#address.phone" /></span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">&nbsp;&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;：</span>
										<span class="new-txt-rd2"><s:property
												value="#address.address" /> </span>
									</p>
								</div>
								<div class="new-addr-btn">
									<a href="<%=path%>/user/Address_deleteAddress?addressNo=<s:property
												value="#address.addressNo"/>" target="_top"><i class="am-icon-trash"></i>删除</a>
								</div></li>
								</s:if>
						</s:iterator>
					</ul>
					<div class="clear"></div>
					<a class="new-abtn-type"
						data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}"
						style="color: black">添加新地址</a>
					<!--例子-->
					<div class="am-modal am-modal-no-btn" id="doc-modal-1">
						<h1></h1>

						<div class="add-dress">

							<!--标题 -->
							<div class="am-cf am-padding">
								<div class="am-fl am-cf">
									<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small>
								</div>
							</div>
							<hr />

							<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
								<form class="am-form am-form-horizontal"
									action="<%=path%>/user/Address_addAddress.action" method="post">

									<div class="am-form-group">
										<label for="user-name" class="am-form-label">收货人姓名</label>
										<div class="am-form-content">
											<input type="text" id="user-name" name="name"
												placeholder="收货人姓名" onblur="checkInputInfo();">
											<span id="sname"></span>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-phone" class="am-form-label">手机号码</label>
										<div class="am-form-content">
											<input id="user-phone" name="phone" placeholder="手机号必填"
												type="text" onblur="checkInputTel();">
												<span id="sphone"></span>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<textarea class="" rows="3" id="user-intro" name="address"
												placeholder="输入详细地址" onblur="checkInputInfo();"></textarea>
											<span id="saddress"></span>
											<small>100字以内写出你的详细地址...</small>
										</div>
									</div>

									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<input class="am-btn am-btn-danger" type="submit" onclick="return checkInput();" value="保存">
											<a href="javascript: void(0)"
												class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
										</div>
									</div>
								</form>
							</div>

						</div>

					</div>

				</div>

				<script type="text/javascript">
					$(document).ready(
							function() {
								$(".new-option-r").click(
										function() {
											$(this).parent('.user-addresslist')
													.addClass("defaultAddr")
													.siblings().removeClass(
															"defaultAddr");
										});

								var $ww = $(window).width();
								if ($ww > 640) {
									$("#doc-modal-1").removeClass(
											"am-modal am-modal-no-btn")
								}

							})
							
							
					
							
		var flag1=0,flag2=0,flag3=0;
		//检查电话
		function checkInputTel() {
			var uText2 = document.getElementById("user-phone").value;
			var label2 = document.getElementById("sphone");
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
		
		
		function checkInputInfo() {
			var uText = document.getElementById("user-name").value;
			var label = document.getElementById("sname");
			var address = document.getElementById("user-intro").value;
			var saddress = document.getElementById("saddress");
			if (uText==""){
				label.style.color = "black";
				label.innerText = "姓名不能为空！"; //显示提示信息
				flag2=0;
			}
			else{
				flag2=1;
			}
			if (address==""){
				saddress.style.color = "black";
				saddress.innerText = "姓名不能为空！"; //显示提示信息
				flag3=0;
			}
			else{
				flag3=1;
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
				<div class="clear"></div>

			</div>
			<!--底部-->
			<div class="footer"></div>
		</div>
	</div>

</body>
</html>