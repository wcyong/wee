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
		<div class="form-group has-error">
			<label class="control-label">错误状态</label>
			<input type="text" class="form-control" placeholder="错误状态">
		</div>
		<div class="form-group has-success">
			<label class="control-label">成功状态</label>
			<input type="text" class="form-control">
		</div>
		<div class="form-group has-warning">
			<label class="control-label">警告状态</label>
			<input type="text" class="form-control">
		</div>
		
		<div class="form-group has-success has-feedback">
		  <label class="control-label" for="inputSuccess1">成功状态</label>
		  <input type="text" class="form-control" id="inputSuccess1" placeholder="成功状态" >
		  <span class="glyphiconglyphicon-ok form-control-feedback"></span>
		</div>
	</form>
</body>
</html>	