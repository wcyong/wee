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
		<div class="checkbox">
			<label>
				<input type="checkbox" value="">记住密码
			</label>
		</div>
		<div class="radio">
			<label>
				<input type="radio" name="name1">喜欢
			</label>
		</div>
		<div class="radio">
			<label>
				<input type="radio" name="name1" checked>不喜欢
			</label>
		</div>
	</form>
</body>
</html>	