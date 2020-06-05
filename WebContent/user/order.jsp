<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>订单中心</title>
	<link rel="stylesheet" type="text/css" href="../ucss/style.css">
</head>
<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="goods.jsp" target="_blank">天天商城</a></li>
						<li><span>欢迎**${sessionScope.loginUser.userName}**登录</span></li>
						<li><a href="<%=path%>/user/User_userLogout.action" target="_blank">退出</a></li>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="#">我的订单</a></div>
					<div class="fr">
						<ul>
							<li><a href="goods.jsp" target="_blank" >返回</a></li>
							<li><a href="login.jsp" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="register.jsp" target="_blank">注册</a></li>
							<li>|</li>
	 						<li><a href="<%=path%>/user/User_userLogout.action" target="_top">退出</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="商品名称">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
	<!-- end banner_x -->
	
	<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="<%=path%>/user/Address_queryAllAddress.action" target="_top">收货地址</a></li>
					<li><a href="<%=path%>/user/Cart_displayCart.action" target="_top">我的购物车</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			
			<s:iterator value="#session.loginUser_order" var="orderlist">
				<div class="ddxq">
<%-- 					<div class="ddbh fl">订单号:<s:property value="#orderlist.orderNo"/></div> --%>
					<div class="ztxx fr">
					<ul>
						<li>商品名称:<span style="color:red;"><s:property value="#orderlist.goodsName"/></span></li>
						<li>购买数量:<s:property value="#orderlist.num"/> </li>
						<li><span style="color:red;"><s:property value="#orderlist.status"/></span></li>
						<li>￥<span style="color:red;"><s:property value="#orderlist.sumPrice"/></span></li>
						<li><s:property value="#orderlist.orderTime"/></li>
						<li><a href="<%=path%>/user/Order_queryOrderDetail.action?orderNo=<s:property value="#orderlist.orderNo"/>">详情</a></li>
					</ul>
				</div>
				<div class="clear"></div>
				</div>
			</s:iterator>
		</div>
		<div class="clear"></div>
		</div>
	</div>
	<!-- self_info -->
</body>
</html>