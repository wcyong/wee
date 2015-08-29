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

	<h3>Example heading <span class="label label-default">New</span></h3>
	
	
	<h3>Example heading <span class="label label-primary">New</span></h3>
	<h3>Example heading <span class="label label-success">New</span></h3>
	<h3>Example heading <span class="label label-info">New</span></h3>
	<h3>Example heading <span class="label label-warning">New</span></h3>
	<h3>Example heading <span class="label label-danger">New</span></h3>
	
	
	<a href="#">Inbox <span class="badge">42</span></a>
	
	<a href="#">Inbox <span class="badge" style="background: #F00;">42</span></a>

	<button class="btn btn-primary" type="button">
	  Messages <span class="badge">4</span>
	</button>
	
	
	<ul class="nav nav-pills" role="tablist">
	  <li role="presentation" class="active"><a href="#">Home <span class="badge">42</span></a></li>
	  <li role="presentation"><a href="#">Profile</a></li>
	  <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
	</ul>
	
	
	
	<div class="jumbotron">
	  <h1>Hello, world!</h1>
	  <p>...</p>
	  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	</div>
	
	<br>
	<div class="jumbotron">
		<div class="container">
		  <h1>Hello, world!</h1>
		  <p>...</p>
		  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
	  </div>
	</div>
	
	<div class="page-header">
	  <h1>Example page header <small>Subtext for header</small></h1>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>