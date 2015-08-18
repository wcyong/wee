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

	<form>
		<input type="text" class="form-control" placeholder="Text input"><br>
		<textarea class="form-control" rows="3"></textarea>
		<br> <label class="radio-inline"> <input type="radio"
			name="inlineRadioOptions" id="inlineRadio1" value="option1">
			1
		</label> <label class="radio-inline"> <input type="radio"
			name="inlineRadioOptions" id="inlineRadio2" value="option2">
			2
		</label> <label class="radio-inline"> <input type="radio"
			name="inlineRadioOptions" id="inlineRadio3" value="option3">
			3
		</label>
	</form>

	<hr>
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword"
					placeholder="Password">
			</div>
		</div>
		<br>
		<input type="text" class="form-control" disabled="disabled">
	</form>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>