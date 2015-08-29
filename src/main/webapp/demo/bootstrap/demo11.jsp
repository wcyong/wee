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

</head>

<body>

	<img alt="img/100.png" src="<%=request.getContextPath()%>/resources/img/100.png" class="img-rounded">
	<img alt="img/100.png" src="<%=request.getContextPath()%>/resources/img/100.png" class="img-circle">
	<img alt="img/100.png" src="<%=request.getContextPath()%>/resources/img/100.png" class="img-thumbnail">
	
	<div class="bg-info pull-left col-sm-4">
		<button type="button" class="btn btn-danger">按钮</button>
		<button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	</div>
	
	<div class="clearfix" style="height: 20px;background: red;">xxx</div>
	
	<div class="center-block bg-info" style="width: 200px; height: 200px;">xxxxxxxxxxxxxxxx</div>
	
	<p class="text-muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
	<p class="text-primary">Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	<p class="text-success">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
	<p class="text-info">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
	<p class="text-warning">Etiam porta sem malesuada magna mollis euismod.</p>
	<p class="text-danger">Donec ullamcorper nulla non metus auctor fringilla.</p>
	
	<p class="bg-primary">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
	<p class="bg-success">Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	<p class="bg-info">Duis mollis, est non commodo luctus, nisi erat porttitor ligula.</p>
	<p class="bg-warning">Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
	<p class="bg-danger">Etiam porta sem malesuada magna mollis euismod.</p>


	

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>