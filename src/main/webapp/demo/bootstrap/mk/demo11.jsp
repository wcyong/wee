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
			<label for="exampleInputEmail1">邮箱：</label>
			<input type="email" class="form-control" placeholder="请输入邮箱" id="exampleInputEmail1">
		</div>
		<div class="form-group">
			<label>密码：</label>
			<input type="password" placeholder="请输入密码" class="form-control">
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