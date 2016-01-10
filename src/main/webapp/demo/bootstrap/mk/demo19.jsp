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
		<div class="form-group has-success has-feedback">
			<label class="control-label">成功状态</label>
			<input type="text" class="form-control">
			<span class="help-block">你输入的信息是正确的</span>
			<span class="glyphiconglyphicon-ok form-control-feedback"></span>
		</div>
		<div class="form-group has-error has-feedback">
			<label class="control-label">错误状态</label>
			<input type="text" class="form-control">
			<span class="help-block">你输入的信息是错误的</span>
		</div>
		<div class="form-group has-warning has-feedback">
			<label class="control-label">错误状态</label>
			<input type="text" class="form-control">
			<span class="help-block">你输入的信息是错误的</span>
		</div>
		
		<div class="form-group">
		<label class="control-label" for="inputSuccess1">成功状态</label>
		<div class="row">
		<div class="col-xs-6">
		<input type="text" class="form-control" id="inputSuccess1" placeholder="成功状态" >
		</div>
		<span class="col-xs-6 help-block">你输入的信息是正确的</span>
		</div>
		</div>
	</form>
</body>
</html>	