<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<link rel="stylesheet" type="text/css" href="../ucss/style.css">
</head>
<body>
	<!-- start banner_x -->
		<div class="banner_x center">
			<div class="wdgwc fl ml40"><a href="../index.jsp" target="_top">商城首页</a></div>
			<div class="wdgwc fl ml40"><a href="<%=path%>/user/Order_queryAllOrder.action" target="_top">我的订单</a></div>
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20"><a href="detail.jsp" target="_top">《返回商品详情</a></div>
			<div class="wxts fl ml20">尊敬的<span style="color: red;">${sessionScope.loginUser.userName}</span>用户，温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
					<li><a href="login.jsp" target="_blank">登录</a></li>
					<li>|</li>
					<li><a href="register.jsp" target="_blank">注册</a></li>	
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl"></div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<s:iterator value="#session.cart.goods" var="good">
				<div class="content2 center">
					<div class="sub_content fl ">
					</div>
					<div class="sub_content fl"><img width="100px" height="100px" src="<s:property value="#good.key.imgUri"/>"></div>
					
					<div class="sub_content fl ft20">&nbsp;&nbsp;<s:property value="#good.key.commodityName"/></div>
					<div class="sub_content fl "><s:property value="#good.key.price"/></div>
					<div class="sub_content fl">
						<input class="shuliang" type="number" value="<s:property value="#good.value"/>" step="1" min="1" >
					</div>
					<div class="sub_content fl"><s:property value="#good.key.price*#good.value"/></div>
					<div class="sub_content fl"><a href="<%=path%>/user/Cart_removeFromCart?commodityNo=<s:property value="#good.key.commodityNo"/>">×</a></div>
					<div class="clear"></div>
				</div>
				</s:iterator>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="./liebiao.html">继续购物</a></li>
						<li>|</li>
						<li>共<span>2</span>件商品，已选择<span>1</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>${sessionScope.cart.totalPrice}元</span></div>
					<div class="jsanniu fr"><a href="<%=path%>/user/Cart_payCart.action"><input class="jsan" type="button" name="jiesuan"  value="去结算"/></a></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

</body>
</html>