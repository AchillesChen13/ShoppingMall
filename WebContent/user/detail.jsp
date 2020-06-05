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
<title>商品详情</title>
<link rel="stylesheet" type="text/css" href="../ucss/style.css">


</head>
<body>
	<!-- start header -->
	<header>
	<div class="top center">
		<div class="left fl">
			<ul>
				<li><a href="../index.jsp" target="_top">天天商城</a></li>
				<li><span>欢迎**<span>${sessionScope.loginUser.userName}</span>**登录
				</span></li>
				<li><a href="<%=path%>/user/User_userLogout.action"
					target="_blank">退出</a></li>
			</ul>
		</div>
		<div class="right fr">
			<div class="gouwuche fr">
				<a href="<%=path%>/user/Order_queryAllOrder.action" target="_top">订单</a>
			</div>
			<div class="gouwuche fr">
				<a href="gouwuche.jsp">购物车</a>
			</div>
			<div class="fr">
				<ul>
					<li><a href="goods.jsp" target="_blank">返回</a></li>
					<li>|</li>
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

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
		<a href=""><div class="ad_top fl"></div></a>
		<div class="search fr">
			<form action="" method="post">
				<div class="text fl">
					<input type="text" class="shuru" placeholder="商品名称">
				</div>
				<div class="submit fl">
					<input type="submit" class="sousuo" value="搜索" />
				</div>
				<div class="clear"></div>
			</form>
			<div class="clear"></div>
		</div>
	</div>
	<!-- end banner_x -->

	<!-- xiangqing -->
	<form action="post" method="">
		<div class="xiangqing">
			<div class="neirong w">
				<div class="xiaomi6 fl">${sessionScope.query_commodity.commodityName}</div>
				<div class="clear"></div>
			</div>
		</div>

		<div class="jieshao mt20 w">
			<div class="left fl">
				<img src="${sessionScope.query_commodity.imgUri}" width="560px"
					height="560px">
			</div>
			<div class="right fr">
				<div class="h3 ml20 mt20">${sessionScope.query_commodity.commodityName}</div>
				<div class="jianjie mr40 ml20 mt10">${sessionScope.query_commodity.content}</div>
				<div class="jiage ml20 mt10">
					<input id="price"
						style="border: none; font-size: 20px; width: 80px; background: none; color: red;"
						value="${sessionScope.query_commodity.price}" readonly="readonly">${sessionScope.query_commodity.unit}</div>
				<div class="ft20 ml20 mt20">生产日期：${sessionScope.query_commodity.produceDate}</div>
				<div class="ft20 ml20 mt20">保质期：${sessionScope.query_commodity.qualityDate}天</div>

				<div class="ft20 ml20 mt20">选择数量:</div>
				<div class="xzbb ml20 mt10">
					<span>
					<input id="buyNum" name="buyNum1" type="text" value="1"
						class="banben fl" onblur="calculatePrice();"><span id="tishi"></span>
					</span>
					<div class="clear"></div>
				</div>

				<div class="xqxq mt20 ml20">
					<div class="top1 mt10">
						<div class="left1 fl">库存:${sessionScope.query_commodity.stock}</div>
						<div class="right1 fr"></div>
						<div class="clear"></div>
					</div>
					<div class="bot mt20 ft20 ftbc">
						总计：<span id="totalprice">${sessionScope.query_commodity.price}</span>元
					</div>
				</div>


				<div class="xiadan ml20 mt20">
<!-- 					<a -->
<%-- 						href="<%=path%>/user/Order_addOrder.action?loginName=${sessionScope.loginUser.userName}&buycno=${sessionScope.query_commodity.commodityNo}&buyNum1="+buyNum></a> --%>
						<input class="jrgwc" type="button" name="jrgwc" value="立即选购"
						onclick="return checkLogin();" />
						<input class="jrgwc" type="button" name="jrgwc" onclick="return addCart();" value="加入购物车" />
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</form>

	<footer class="mt20 center">
	<div class="mt20">天天商城</div>
	<div>
		<a href="../manage/login.jsp">@</a>违法和不良信息举报电话：156-8416-8890
	</div>
	</footer>

	<script type="text/javascript">
		var flag = 1;
		var num = 1;
		var tishi = document.getElementById("tishi");
		function calculatePrice(){
			var buyNum = parseFloat(document.getElementById("buyNum").value);
			var tishi = document.getElementById("tishi");
			var price = parseFloat(document.getElementById("price").value);
			var totalprice = document.getElementById("totalprice");
			var rs = parseFloat(buyNum*price);
			var stock = parseFloat("${sessionScope.query_commodity.stock}");
			if (buyNum<=stock){
				if (price!=0){
					totalprice.style.color = "red";
					totalprice.innerText = rs;
					num=buyNum;
					flag=1;
				}
			}
			else{
				flag=0;
				tishi.style.color = "red";
				tishi.innerText = "库存不足!";
			}
		}
		function checkLogin(){
			var loginuser = "${sessionScope.loginUser.userName}";
			if (loginuser.length!=0){
				if (flag==1){
					document.location.href="<%=path%>/user/Order_addOrder.action?loginName=${sessionScope.loginUser.userName}&buycno=${sessionScope.query_commodity.commodityNo}&buyNum1="+num;
					return true;
				}
				else{
					tishi.style.color = "red";
					tishi.innerText = "库存不足!";
					return false;
				}
			}
			else{
				alert("请先登录！");
				return false;
			}
		}
		
		function addCart(){
			var loginuser = "${sessionScope.loginUser.userName}";
			if (loginuser.length!=0){
				if (flag==1){
					document.location.href="<%=path%>/user/Cart_addInCart.action?buycno=${sessionScope.query_commodity.commodityNo}&buyNum="+num;
					return true;
				}
				else{
					tishi.style.color = "red";
					tishi.innerText = "库存不足!";
					return false;
				}
			}
			else{
				alert("请先登录！");
				judgeStock();
				return false;
			}
		}
		
		
		function getBuynum(){
			return num;
		}
		
		function judgeStock(){
			var stockErorr = "sessionScope.stockError";
			var nameNull = "sessionScope.nameNull";
			var addressNull = "sessionScope.addressNull";
			if (stockErorr.length==0){
				alert("数量输入错误！");
			}
			if (stockErorr.length==0){
				alert("未登录！");
			}
			if (addressNull.length==0){
				alert("还未添加配送地址！")
			}
		}
		
	</script>
	<script type="text/javascript">
	</script>
</body>
</html>