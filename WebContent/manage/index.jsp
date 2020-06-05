<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>……</title>
<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../mjs/jquery.js"></script>


</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="main.jsp">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex"></div>
    
    
    <div class="welinfo">
    <span><img src="../mImages/sun.png" alt="天气" /></span>
    <b>${sessionScope.loginSupName}早上好，欢迎使用信息管理系统</b>
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    <li><img src="../mImages/ico02.png" /><p><a href="goodsManage.jsp">商品管理</a></p></li>
    <li><img src="../mImages/ico03.png" /><p><a href="orderlist.jsp">订单管理</a></p></li>
    <li><img src="../mImages/ico06.png" /><p><a href="#">查询</a></p></li>
    </ul>
    
    <div class="xline"></div>
    <div class="box"></div>
    
</body>
</html>