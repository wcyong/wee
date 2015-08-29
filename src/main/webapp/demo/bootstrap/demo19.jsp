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

	<div class="progress">
		<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
			<span class="sr-only">60% Complete</span>
		</div>
	</div>	
	<br>
	<div class="progress">
	  <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
	    60%
	  </div>
	</div>
	<br>
	
	<div class="progress">
	  <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em;">
	    0%
	  </div>
	</div>
	<div class="progress ">
	  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em; width: 2%;">
	    2%
	  </div>
		  <div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">
	    <span class="sr-only">20% Complete (warning)</span>
	  </div>
	  <div class="progress-bar progress-bar-danger" style="width: 10%">
	    <span class="sr-only">10% Complete (danger)</span>
	  </div>
	</div>
	
	<br>
	<div class="well well-lg">Look, I'm in a large well!</div>
	<div class="well well-sm">Look, I'm in a large well!</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>