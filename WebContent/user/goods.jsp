<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="../ucss/style.css">
</head>
<body>
	<!-- start header -->
	<header>
	<div class="top center">
		<div class="left fl">
			<ul>
				<li><a href="goods.jsp" target="_blank">天天商城</a></li>
				<li><span>欢饮**<span id="loginName">${sessionScope.loginUser.userName}</span>**登录</span></li>
				<li><a href="<%=path%>/user/User_userLogout.action"
					target="_blank">退出</a></li>
			</ul>
		</div>
		<div class="right fr">
			<div class="gouwuche fr">
				<a href="<%=path%>/user/Order_queryAllOrder.action" target="_top">订单</a>
			</div>
			<div class="gouwuche fr">
				<a href="<%=path%>/user/Cart_displayCart.action" target="_top">购物车</a>
			</div>
			<div class="fr">
				<ul>
					<li><a href="login.jsp" target="_blank">登录</a></li>
					<li>|</li>
					<li><a href="register.jsp" target="_blank">注册</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	</header>
	<!--end header -->


	<!-- start danpin -->
	<div class="danpin center">

		<div class="biaoti center">天天商城</div>
		<div class="main center mb20">
			<s:iterator value="#session.commodity_list" var="clist">
					<div class="mingxing fl mb20"
						style="border: 2px solid #fff; width: 230px; cursor: pointer;"
						onmouseout="this.style.border='2px solid #fff'"
						onmousemove="this.style.border='2px solid red'">
						<div class="sub_mingxing">
							<a href="<%=path%>/user/Commodity_queryCommodityById.action?commodityNo=<s:property value="#clist.commodityNo"/>" target="_blank"><img
								src="<s:property value="#clist.imgUri"/>" alt=""></a>
						</div>
						<div class="pinpai">
							<a href="<%=path%>/user/Commodity_queryCommodityById.action?commodityNo=<s:property value="#clist.commodityNo"/>" target="_blank"><s:property
									value="#clist.commodityName"/></a>
						</div>
						<div class="youhui">
							<s:property value="#clist.content" />
						</div>
						<div class="jiage">
							<s:property value="#clist.price"/><s:property value="#clist.unit"/>
						</div>
					</div>
			</s:iterator>
			<div class="clear"></div>
		</div>

	</div>
	
<!-- 	<footer class="mt20 center">			 -->
<!-- 			<div class="mt20">天天商城</div> -->
<!-- 			<div><a href="../manage/login.jsp">@</a>违法和不良信息举报电话：156-8416-8890</div> -->
<!-- 	</footer> -->
</body>
</html>