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
			<label class="checkbox-inline">
				<input type="checkbox" value="1">足球
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" value="2">篮球
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" value="3">羽毛球
			</label>
		</div>
		<div class="form-group">
			<label class="radio-inline">
				<input type="radio" name="sex" value="1">男
			</label>
			<label class="radio-inline">
				<input type="radio" name="sex" value="2">女
			</label>
			<label class="radio-inline">
				<input type="radio" name="sex" value="3">中性
			</label>
		</div>
	</form>
</body>
</html>	