<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<title>Starter Template for Bootstrap</title>

<link
	href="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

div {
	display: block;
}

.dowebok .row {
	font-size: 0;
	text-align: center;
}

.dowebok .wow {
	display: inline-block;
	width: 380px;
	height: 50px;
	margin: 10px 5px 0;
	border-radius: 10;
	/* font: 30px/280px "Microsoft Yahei"; */
	vertical-align: top;
	zoom: 1;
	background: #f0f0f0;
}
</style>
</head>

<body>


	<div class="container">
		<div class="dowebok">
			<div class="row">
				<div class="wow">ss</div>
				<div class="wow">look</div>
			</div>
			<div class="row">
				<div class="wow">ss</div>
				<div class="wow">look</div>
			</div>
			<div class="row">
				<div class="wow">ss</div>
				<div class="wow">look</div>
			</div>
			<div class="row">
				<div class="wow">ss</div>
				<div class="wow">look</div>
			</div>
		</div>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>