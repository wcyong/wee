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

	<div class="row">
		<div class="col-xs-6 col-md-1">
			<a href="#" class="thumbnail">
				<img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
			</a>
			<a href="#" class="thumbnail">
				<img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
			</a>
			<a href="#" class="thumbnail">
				<img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
			</a>
		</div>
		<div class="col-xs-6 col-md-3">
			<a href="#" class="thumbnail">
				<img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
			</a>
		</div>
		<div class="col-xs-6 col-md-3">
			<a href="#" class="thumbnail">
				<img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
			</a>
		</div>
	</div>
	
	
	<br>
	
	<div class="row">
	  <div class="col-sm-6 col-md-2">
	    <div class="thumbnail">
	     <img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
	      <div class="caption">
	        <h3>Thumbnail label</h3>
	        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit
	        	 non mi porta gravida at eget metus.
	        	 Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a>
	        <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 col-md-2">
	    <div class="thumbnail">
	     <img src="<%=request.getContextPath()%>/resources/img/100.png" alt="...">
	      <div class="caption">
	        <h3>Thumbnail label</h3>
	        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit
	        	 non mi porta gravida at eget metus.
	        	 Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
	        <p><a href="#" class="btn btn-primary" role="button">Button</a>
	        <a href="#" class="btn btn-default" role="button">Button</a></p>
	      </div>
	    </div>
	  </div>
	</div>
	
	<br>
	
	<div class="alert alert-success" role="alert">Well done! You successfully read this important alert message.</div>
	<div class="alert alert-info" role="alert">Heads up! This alert needs your attention, but it's not super important.</div>
	<div class="alert alert-warning" role="alert">Warning! Better check yourself, you're not looking too good.</div>
	<div class="alert alert-danger" role="alert">Oh snap! Change a few things up and try submitting again.</div>

	<br>
	
	<div class="alert alert-warning alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Warning!</strong> Better check yourself, you're not looking too good.
	</div>
	
	<br>
	
	
	<div class="alert alert-success" role="alert">
	  <a href="#" class="alert-link">Better check yourself, you're not looking too good.</a>
	</div>
	<div class="alert alert-info" role="alert">
	  <a href="#" class="alert-link">...</a>
	</div>
	<div class="alert alert-warning" role="alert">
	  <a href="#" class="alert-link">...</a>
	</div>
	<div class="alert alert-danger" role="alert">
	  <a href="#" class="alert-link">...</a>
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