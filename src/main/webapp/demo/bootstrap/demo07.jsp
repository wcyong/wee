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
  
  	<!-- 输入框组 -->
  	<div class="input-group">
  		<span class="input-group-addon">@</span>
  		<input type="text" name="username" id="usernmae" class="form-control">
  	</div>
  	
  	<hr>
  	
  	<div class="input-group">
  		<input type="text" name="username" id="usernmae" class="form-control">
  		<span class="input-group-addon">@</span>
  	</div>
  	
  	<hr>
  	<div class="input-group">
  		<span class="input-group-addon">@</span>
  		<input type="text" name="username" id="usernmae" class="form-control">
  		<span class="input-group-addon">qq</span>
  	</div>
  	
  	<hr>
  	<div class="input-group input-group-lg">
  		<input type="text" name="username" id="usernmae" class="form-control">
  		<span class="input-group-addon">@</span>
  	</div>
  	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>