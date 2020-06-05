<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商品</title>
<link href="../mcss/style.css" rel="stylesheet" type="text/css" />
<link href="../mcss/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../mjs/jquery.js"></script>
<script type="text/javascript" src="../mjs/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../mjs/select-ui.min.js"></script>
<script type="text/javascript" src="../mjs/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="../editor/kindeditor.js"></script>
<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="main.jsp">首页</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">添加商品</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">

				<div class="formtext">
					Hi，<b>${sessionScope.loginSupName}</b>，欢迎您使用商品发布功能！
				</div>


				<form action="<%=path%>/manage/Commodity_modifyCommodity.action" method="post">

					<ul class="forminfo">

						<li><label>商品编号<b>*</b></label> <input name="commodityNo"
							type="text" class="dfinput"
							value='<s:property value="#session.modify_commodity.commodityNo"/>'
							style="width: 518px;" readonly="readonly" />
						</li>

						<li><label>商品名称<b>*</b></label><input name="commodityName"
							type="text" class="dfinput"
							value='<s:property value="#session.modify_commodity.commodityName"/>'
							style="width: 518px;"/>
						</li>


						<li><label>商品类型<b>*</b></label>
							<div class="usercity">
								<input name="typeName" type="text" class="dfinput"
									value='<s:property value="#session.modify_commodity.typeName"/>'
									style="width: 518px;" />
							</div>
						</li>
						
						</br>
						
						<li><label>商品价格<b>*</b></label> 
						<div>
							<input name="price" type="text" class="dfinput" 
						value='<s:property value="#session.modify_commodity.price" />' style="width: 518px;"
							/>
						</div>
						</li>

						<li><label>单价单位<b>*</b></label>
							<div class="usercity">
								<input name="unit" type="text" class="dfinput"
									value='<s:property value="#session.modify_commodity.unit"/>'
									style="width: 518px;" />
							</div>
						</li>
						
						</br>
						<li><label>库存数量<b>*</b></label> <input name="stock"
							type="text" class="dfinput"
							value='<s:property value="#session.modify_commodity.stock" />' style="width: 518px;"
							/>
						</li>

						<li><label>生产日期<b>*</b></label> <input name="produceDate"
							type="text" class="dfinput"
							value='<s:date name="#session.modify_commodity.produceDate"/>' style="width:
							518px;" />
						</li>

						<li><label>保质期<b>*</b></label> <input name="qualityDate"
							type="text" class="dfinput"
							value='<s:property value="#session.modify_commodity.qualityDate"/>' style="width:
							518px;" />
						</li>

						<li><label>商品描述<b>*</b></label> <input name="content"
							type="text" class="dfinput"
							value='<s:property value="#session.modify_commodity.content" />' style="width:
							518px;" />
						</li>

						<li><label>商品图片<b>*</b></label> 
						<input id="img1" type="text"
							name="imgurl" type="text" class="dfinput" value='<s:property value="#session.modify_commodity.imgUri" />' readonly="readonly"><br>
						</br>
						<input type="file" id="img2"
							name="imgUri" onchange="PreviewImage(this)" id="upload" value="" ><br>
						<img id="imgPreview" name=""
							style="width: 200px; height: 200px; border-color: black;">
						</li>
						
<!-- 						<li><label>修改图片<b>*</b></label> <input type="file" -->
<!-- 							name="imgUri" onchange="PreviewImage(this)" id="upload"><br> -->
<!-- 							<div> -->
<!-- 								<img id="imgPreview" style="width: 200px; height: 200px;border-color: black;"> -->
<!-- 							</div> -->
<!-- 						</li> -->


			<li><label>&nbsp;</label> <input name="" type="submit"
				class="btn" onclick="setImgURL();" value="马上修改" /></li>
			</ul>
			</form>

		</div>

	</div>

	<script type="text/javascript">
		function PreviewImage(imgFile) {

			var filextension = imgFile.value.substring(imgFile.value
					.lastIndexOf("."), imgFile.value.length);

			filextension = filextension.toLowerCase();
			if ((filextension != '.jpg') && (filextension != '.gif')
					&& (filextension != '.jpeg') && (filextension != '.png')
					&& (filextension != '.bmp')) {
				alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 !");
				imgFile.focus();
			} else {
				var path;
				if (document.all)//IE
				{
					imgFile.select();
					path = document.selection.createRange().text;

					document.getElementById("imgPreview").innerHTML = "";
					document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\""
							+ path + "\")";//使用滤镜效果  
				} else//FF
				{
					// 						path = imgFile.files[0].getAsDataURL();
					path = window.URL.createObjectURL(imgFile.files[0]);
					// 						document.getElementById("upath").innerHTML = path;
					document.getElementById("imgPreview").innerHTML = "<img id='img1' width='120px' height='100px' src='"+path+"'/>";
					// document.getElementById("img1").src = path;
				}
			}
		}
	</script>
	
	<script type="text/javascript">
		function setImgURL(){
			var imgUri = document.getElementById("img2").value;
			var imgUrl = document.getElementById("img1").value;
			if ((imgUri.length==0)&&(imgUrl.length!=0)){
				imgUri=imgUrl;
			}
		}
	
	</script>

	<script type="text/javascript">
		$("#usual1 ul").idTabs();
	</script>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

	</div>
</body>
</html>