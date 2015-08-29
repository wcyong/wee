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


	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	</ul>

	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	</ul>
	
	<ul class="nav nav-pills nav-stacked">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	</ul>
	
	<ul class="nav nav-pills nav-justified">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	</ul>
	
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation" class="disabled"><a href="#">Messages</a></li>
	</ul>
	
	
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation" class="dropdown">
			<a class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      			Dropdown <span class="caret"></span>
    		</a>
    		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			    <li><a href="#">Action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Something else here</a></li>
			    <li><a href="#">Separated link</a></li>
		    </ul>
		</li>
	</ul>
	
	<ul class="nav nav-pills">
		<li role="presentation"><a href="#">Home</a></li>
		<li role="presentation"><a href="#">Profile</a></li>
		<li role="presentation" class="dropdown active">
			<a class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      			Dropdown <span class="caret"></span>
    		</a>
    		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			    <li><a href="#">Action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Something else here</a></li>
			    <li><a href="#">Separated link</a></li>
		    </ul>
		</li>
	</ul>
	


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>