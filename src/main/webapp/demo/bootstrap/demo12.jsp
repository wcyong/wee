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
	div {
		border: solid 1px #cccccc;
	}
</style>

</head>

<body>

	<div class="container bg-info">
		<div class="row">
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
		</div>
		<div class="row">
			<div class="col-md-8">.col-md-8</div>
			<div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row">
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row">
			<div class="col-md-6">.col-md-6</div>
			<div class="col-md-6">.col-md-6</div>
		</div>
	</div>

	<div class="container bg-success">
		<!-- Stack the columns on mobile by making one full-width and the other half-width -->
		<div class="row">
			<div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
			<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		</div>

		<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
		<div class="row">
			<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
			<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
			<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
		</div>

		<!-- Columns are always 50% wide, on mobile and desktop -->
		<div class="row">
			<div class="col-xs-6">.col-xs-6</div>
			<div class="col-xs-6">.col-xs-6</div>
		</div>
	</div>

	<div class="container bg-warning">
		<div class="row">
			<div class="col-xs-9">.col-xs-9</div>
			<div class="col-xs-4">
				.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div
				gets wrapped onto a new line as one contiguous unit.
			</div>
			<div class="col-xs-6">
				.col-xs-6<br>Subsequent columns continue along the new line.
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-xs-9">.col-xs-9</div>
			<div class="col-xs-4">
				.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div
				gets wrapped onto a new line as one contiguous unit.
			</div>
			<div class="col-xs-6">
				.col-xs-6<br>Subsequent columns continue along the new line.
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4 col-md-offset-1">.col-md-4
				.col-md-offset-4</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-md-offset-1">.col-md-3
				.col-md-offset-3</div>
			<div class="col-md-3 col-md-offset-3">.col-md-3
				.col-md-offset-3</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">.col-md-6
				.col-md-offset-3</div>
		</div>
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