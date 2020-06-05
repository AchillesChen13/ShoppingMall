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
<title>商品列表</title>
<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../mjs/jquery.js"></script>
<script language="javascript">
	$(function() {
		//导航切换
		$(".imglist li").click(function() {
			$(".imglist li.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>
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
			<li><a href="main.jsp">首页</a></li>
			<li><a href="#">商品列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="click"><a href="addType.jsp"><span><img
							src="../mImages/t01.png" /></span>添加</a></li>
				<li class="click"><a href="addType.jsp"><span><img
							src="../mImages/t01.png" /></span>修改</a></li>
			</ul>
		</div>

		<table class="imgtable">

			<thead>
				<tr>
					<th>类型编号</th>
					<th>类型名称</th>
					<th>修改类型名称</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="#session.type_list" var="tplist">
					<tr>
						<td><s:property value="#tplist.typeNo"/></td>
						<td><s:property value="#tplist.typeName"/></td>
						<td><a href="<%=path%>/manage/Type_queryTypeById.action?typeNo=<s:property value="#tplist.typeNo"/>">修改</a> </td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 		提示信息区域 -->
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
		$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>