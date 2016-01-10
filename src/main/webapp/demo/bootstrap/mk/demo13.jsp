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
	<form role="form" class="form-inline">
		<div class="form-group">
			<label class="sr-only">邮箱：</label>
			<input type="text" class="form-control" placeholder="请输入邮箱">
		</div>
		<div class="form-group">
			<label class="sr-only">密码：</label>
			<input type="password" class="form-control" placeholder="请输入 密码">
		</div>
		<div class="checkbox">
			<label>
				<input type="checkbox">记住密码
			</label>
		</div>
		<button type="submit" class="btn btn-default">进入邮箱</button>
	</form>
</body>
</html>	