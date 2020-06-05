<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>订单列表</title>

<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../mjs/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="#">订单管理</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		
		<div class="tools">

			<ul class="toolbar">
				<li class="click"><a href="<%=path%>/manage/Order_queryOrderByState.action?orderStateCode=1"><span><img
							src="../mImages/t01.png" /></span>待处理订单</a></li>
				<li class="click"><a href="<%=path%>/manage/Order_queryOrderByState.action?orderStateCode=2"><span><img src="../mImages/t02.png" /></span>待配送订单</a></li>
				<li><a href="<%=path%>/manage/Order_queryOrderByState.action?orderStateCode=3"><span><img src="../mImages/t04.png" /></span>待收货订单</a></li>
				<li><a href="<%=path%>/manage/Order_queryOrderByState.action?orderStateCode=4"><span><img src="../mImages/t04.png" /></span>已结束订单</a></li>
			</ul>
		</div>
		
		<table class="tablelist">
			<thead>
				<tr>
<!-- 					<th><input name="" type="checkbox" value="" checked="checked" /></th> -->
					<th>订单编号</th>
					<th>商品名称</th>
					<th>购买数量</th>
					<th>订单状态</th>
					<th>总价</th>
					<th>下单时间</th>
					<th>收件人姓名</th>
					<th>收件人地址</th>
					<th>收件人电话</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<s:iterator value="#session.dbs" var="order">
					<tr>
<!-- 						<td><input name="" type="checkbox" value="" /></td> -->
						<td><s:property value="#order.orderNo"/> </td>
						<td><s:property value="#order.goodsName"/></td>
						<td><s:property value="#order.num"/></td>
						<td><s:property value="#order.status"/></td>
						<td><s:property value="#order.sumPrice"/></td>
						<td><s:property value="#order.orderTime"/></td>
						<td><s:property value="#order.recipeName"/></td>
						<td><s:property value="#order.recipePhone"/></td>
						<td><s:property value="#order.recipeAddre"/></td>
						<td><a href="<%=path%>/manage/Order_manageOrder.action?orderState=<s:property value="#order.status"/>&orderNo=<s:property value="#order.orderNo"/>"
							class="tablelink">修改状态</a></td>
					</tr>
				</s:iterator>
			</tbody>

		</table>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="../mImages/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="cancel" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>

		</div>

	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>