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
	<form role="form" class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label">邮箱：</label>
			<div class="col-sm-10">
				<input type="text" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">密码:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-10 col-sm-offset-2">
				<div class="checkbox">
					<input type="checkbox">记住密码
				</div>
			</div>
		</div>
		<div class="form-group">
		    <div class="col-sm-10 col-sm-offset-2">
		      <button type="submit" class="btn btn-default">进入邮箱</button>
		    </div>
	    </div>
	</form>
</body>
</html>	