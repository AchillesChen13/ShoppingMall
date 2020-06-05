<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../mjs/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>
<body style="background:url(../mImages/topbg.gif) repeat-x;">
	<div class="topleft">
    <a href="main.jsp" target="_parent"><img src="../mImages/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="<%=path%>/manage/Commodity_queryAllCommodity.action?qcFlag=2" target="rightFrame"><img src="../mImages/icon02.png" title="商品管理" /><h2>商品管理</h2></a></li>
    <li><a href="orderlist.jsp"  target="rightFrame"><img src="../mImages/icon03.png" title="订单管理" /><h2>订单管理</h2></a></li>
    <li><a href="<%=path%>/manage/Type_queryAllType.action?tcode=0"  target="rightFrame"><img src="../mImages/icon06.png" title="添加商品" /><h2>添加商品</h2></a></li>
    <li><a href="addType.jsp"  target="rightFrame"><img src="../mImages/icon06.png" title="添加商品类型" /><h2>添加商品类型</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><a href="<%=path%>/manage/Supermarket_supLogout.action" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    	<span>${sessionScope.loginSupName}</span>
    </div>    
    
    </div>
</body>
</html>