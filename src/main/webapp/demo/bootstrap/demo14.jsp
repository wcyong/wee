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

	<nav class="navbar navbar-default navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"> <img alt="Brand" src="<%=request.getContextPath()%>/resources/img/brand.png">
				</a>
			</div>
			<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
			<button type="button" class="btn btn-default navbar-btn">Sing in</button>
		</div>
	</nav>
	
	<br>
	
	<form class="navbar-form navbar-left" role="search">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
	<br>
	
	<div class="clearfix"></div>
	
	<ol class="breadcrumb">
		 <li><a href="#">Home</a></li>
		 <li><a href="#">Library</a></li>
		 <li class="active">Data</li>
	</ol>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>