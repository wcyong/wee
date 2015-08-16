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
  	
  	<!-- 按钮 -->
  	<button type="button" class="btn btn-default">按钮</button>
  	<button type="button" class="btn btn-primary">primary</button>
  	<button type="button" class="btn btn-success">确定</button>
  	<button type="button" class="btn btn-info">信息</button>
  	<button type="button" class="btn btn-warning">提示</button>
  	<button type="button" class="btn btn-danger">取消</button>
  	<button type="button" class="btn btn-link">link</button>
  	
  	<hr>
  	
  	<!-- 设置按钮大小 -->
  	<button type="button" class="btn btn-info btn-lg">信息</button>
  	<button type="button" class="btn btn-warning btn-sm">提示</button>
  	<button type="button" class="btn btn-danger btn-xs">取消</button>
  	
  	<hr>
  	
  	<!-- 其他定义按钮的方式 -->
  	<a class="btn btn-default" href="#" role="button">link</a>
  	<button class="btn btn-default" type="submit">button</button>
  	<input class="btn btn-default" type="button" value="input">
  	<input class="btn btn-default" type="submit" value="submit">
  	
  	<hr>
  	
  	<!-- 在按钮上增加图标 -->
  	<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-upload"></span>&nbsp;&nbsp;button</button>
  

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>