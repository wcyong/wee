<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>标题（一）</title>
 <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<form role="form">
		<div class="form-group">
			<label class="control-lable">比正常的大</label>
			<input type="text" class="form-control input-lg" placeholder="变大">
		</div>
		<div class="form-group">
			<label class="control-lable">正常控件大小</label>
			<input class="form-control" placeholder="正常">
		</div>
		<div class="form-group">
			<label class="control-lable">小于正常控件</label>
			<input type="text" placeholder="input-sm" class="form-control input-sm">
		</div>
	</form>
	
	<form role="form" class="form-horizontal">
		<div class="form-group">
			<div class="col-xs-4">
				<input type="text" class="form-control">
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control">
			</div>
			<div class="col-xs-4">
				<input type="text" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-6">
				<input type="text" class="form-control">
			</div>
			<div class="col-xs-6">
				<input type="text" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-xs-5">
				<input type="text" class="form-control">
			</div>
			<div class="col-xs-7">
				<input type="text" class="form-control">
			</div>
		</div>
	</form>
</body>
</html>	