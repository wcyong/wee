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

    <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

  </head>

  <body>
  
	<form>
		<div class="form-group">
			<label for="username">用户名</label>
			<input type="text" name="username" id="username" class="form-control"><br>
		</div>
		<div class="form-group">
			<label for="password">密码</label>
			<input type="password" id="password" name="password" class="form-control"><br>
		</div>
		<button type="button" class="btn btn-success" >提交</button>
		<button type="button" class="btn btn-warning">重置</button>
	</form>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>