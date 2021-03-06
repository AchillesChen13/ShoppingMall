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
				<li class="click"><a href="addGoods.jsp"><span><img
							src="../mImages/t01.png" /></span>添加</a></li>
				<li><span><img src="../mImages/t04.png" /></span>统计</li>
			</ul>
		</div>

		<table class="imgtable">

			<thead>
				<tr>
					<th width="100px;">缩略图</th>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品类型</th>
					<th>价格</th>
					<th>库存</th>
					<th>生产日期</th>
					<th>保质期</th>
					<th>商品描述</th>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="#session.commodity_list" var="clist">
					<tr>
						<td class="imgtd"><img src="<s:property value="#clist.imgUri"/>" width="200px" /></td>
						<td><s:property value="#clist.commodityNo"/></td>
						<td><s:property value="#clist.commodityName"/></td>
						<td><s:property value="#clist.typeName"/></td>
						<td><s:property value="#clist.price"/><s:property value="#clist.unit"/></td>
						<td><s:property value="#clist.stock"/></td>
						<td><s:date name="#clist.produceDate" format="yyyy年MM月dd日"/></td>
						<td><s:property value="#clist.qualityDate"/></td>
						<td><s:property value="#clist.content"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

<!-- 		<div class="pagin"> -->
<!-- 			<div class="message"> -->
<!-- 				共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页 -->
<!-- 			</div> -->
<!-- 			<!-- 			界面页数 	-->
<!-- 			<ul class="paginList"> -->
<%-- 				<li class="paginItem"><a href="javascript:;"><span --%>
<%-- 						class="pagepre"></span></a></li> --%>
<!-- 				<li class="paginItem"><a href="javascript:;">1</a></li> -->
<!-- 				<li class="paginItem current"><a href="javascript:;">2</a></li> -->
<%-- 				<li class="paginItem"><a href="javascript:;"><span --%>
<%-- 						class="pagenxt"></span></a></li> --%>
<!-- 			</ul> -->
<!-- 		</div> -->


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