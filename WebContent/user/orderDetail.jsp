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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>订单详情</title>
<link href="../ucss/admin.css" rel="stylesheet" type="text/css">
<link href="../ucss/amazeui.css" rel="stylesheet" type="text/css">

<link href="../ucss/personal.css" rel="stylesheet" type="text/css">
<link href="../ucss/orstyle.css" rel="stylesheet" type="text/css">

<script src="../mjs/jquery.min.js"></script>
<script src="../mjs/amazeui.js"></script>
</head>
<body>
	<!--头 -->
	<header> <article>
	<div class="mt-logo">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="login.jsp" target="_top" class="h">欢迎~<span>${sessionScope.loginUser.userName}</span>~亲，登录
						</a> <a href="register.jsp" target="_top">免费注册</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="../index.jsp" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="order.jsp" target="_top" class="h">我的订单</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="gouwuche.jsp" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</a>
					</div>
				</div>
			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="clear"></div>
	</div>
	</article> </header>

	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="user-orderinfo">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单详情</strong> / <small>Order&nbsp;details</small>
						</div>
					</div>
					<hr />
					<div class="order-infoaside">
						
						<div class="order-addresslist">
							<div class="order-address">
								<div class="icon-add"></div>
								<p class="new-tit new-p-re">
									<span class="new-txt">收货人姓名：<span>${sessionScope.orderDB.recipeName}</span></span><br> <span class="new-txt-rd2">收货人电话：<span>${sessionScope.orderDB.recipePhone}</span></span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">收货地址：</span> <span class="province">${sessionScope.orderDB.recipeAddre}</span>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="order-infomain">

						<div class="order-top">
							<div class="th th-number">
								<td class="td-inner">订单编号</td>
							</div>
							<div class="th th-item">
								<td class="td-inner">下单时间</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">商品名称</td>
							</div>
							<div class="th th-number">
								<td class="td-inner">数量</td>
							</div>
							<div class="th th-operation">
								<td class="td-inner">商品操作</td>
							</div>
							<div class="th th-amount">
								<td class="td-inner">合计</td>
							</div>
							<div class="th th-status">
								<td class="td-inner">交易状态</td>
							</div>
							<div class="th th-change">
								<td class="td-inner">交易操作</td>
							</div>
						</div>

						<div class="order-main">
							<div class="order-status3">
								<div class="order-content">
									<div class="order-left">
										<ul class="item-list">
											<li class="td td-number">
												<div class="item-number">
												${sessionScope.orderDB.orderNo}
												</div>
											</li>
											<li class="td td-item">
												<div class="item-info">
														<a href="#">
															<p>${sessionScope.orderDB.orderTime}</p>
														</a>
												</div>
											</li>
											<li class="td td-number">
												<div class="item-number">${sessionScope.orderDB.goodsName}
												</div>
											</li>
											<li class="td td-number">
												<div class="item-number">
													<span>×</span>${sessionScope.orderDB.num}
												</div>
											</li>
											<li class="td td-change">
												<div class="am-btn am-btn-danger anniu"><input class="am-btn am-btn-danger anniu" width="70px" onclick="return notionCancle();" value="取消订单" type="button"></div>
											</li>
											<li class="td td-price">
												<div class="item-price">${sessionScope.orderDB.sumPrice}</div>
											</li>
											<li class="td td-price">
												<div class="item-price">${sessionScope.orderDB.status}</div>
											</li>
											<li class="td td-change">
												<div class="am-btn am-btn-danger anniu"><input class="am-btn am-btn-danger anniu" width="70px" onclick="return notionAccept();" value="确认收货" type="button"></div>
											</li>
										</ul>
										</div>
									</div>
								
								</div>

							</div>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function checkOrderState(){
			var orderState = "${sessionScope.orderDB.status}";
			var normalState = "待处理";
			if (orderState.toString()==normalState.toString()){
				return true;
			}
			else{
				return false;
			}
		}
		
		function endOrderState(){
			var orderState = "${sessionScope.orderDB.status}";
			var normalState = "待收货";
			if (orderState.toString()==normalState.toString()){
				return true;
			}
			else{
				return false;
			}
		}
		
		function notionCancle(){
			var me1 = checkOrderState();
			var cancleState = "已取消";
			if (confirm('确认要取消吗？')){
				if (me1){
					document.location.href="<%=path%>/user/Order_modifyOrder.action?orderNo=${sessionScope.orderDB.orderNo}&orderState=${sessionScope.orderDB.status}";
				}
				else{
					alert("订单已经被处理，不能取消了！");
				}
			}
			else{
				return false;
			}
		}
		
		function notionAccept(){
			var me2 = endOrderState();
			var acceptState = "已收货";
			if (confirm('已经确认收货了吗？')){
				if (me2){
					document.location.href="<%=path%>/user/Order_modifyOrder.action?orderNo=${sessionScope.orderDB.orderNo}&orderState=${sessionScope.orderDB.status}";
				}
				else{
					alert("操作错误！");
				}
			}
			else{
				return false;
			}
		}
	</script>

</body>
</html>