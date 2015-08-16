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
  
  	<!-- 按钮组 -->
	<div class="btn-group">
		<button type="button" class="btn btn-default btn-warning">左边</button>
  		<button type="button btn-info" class="btn btn-default btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-default btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-default btn-warning">右边</button>
	</div>
	
	<hr>
	<!-- 按钮组尺寸 -->
	<div class="btn-group btn-group-lg">
		<button type="button" class="btn btn-default btn-warning">左边</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">右边</button>
	</div>
	
	<div class="btn-group btn-group-sm">
		<button type="button" class="btn btn-warning">左边</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">右边</button>
	</div>
	
	<div class="btn-group btn-group-xs">
		<button type="button" class="btn btn-warning">左边</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">中间</button>
  		<button type="button btn-info" class="btn btn-warning">右边</button>
	</div>
	
	<hr>
	
	<!-- 按钮工具栏 -->
	<div class="btn-toolbar">
		<div class="btn-group">
			<button type="button" class="btn btn-default btn-warning">左边</button>
	  		<button type="button btn-info" class="btn btn-warning">中间</button>
	  		<button type="button btn-info" class="btn btn-warning">中间</button>
	  		<button type="button btn-info" class="btn btn-warning">右边</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-warning">左边</button>
	  		<button type="button btn-info" class="btn btn-warning">中间</button>
		</div>
		<div class="btn-group">
	  		<button type="button btn-info" class="btn btn-warning">右边</button>
		</div>
	</div>
	
	<hr>
	
	<!-- 嵌套 -->
	<div class="btn-group">
		<button type="button" class="btn btn-warning">1</button>
		<button type="button" class="btn btn-warning">2</button>
		<button type="button" class="btn btn-warning">3</button>
		<button type="button" class="btn btn-warning">4</button>
		<button type="button" class="btn btn-warning">5</button>
		<div class="btn-group">
			<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" ria-haspopup="true" aria-expanded="false">
				dropdown
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">Dropdown link</a></li>
	      		<li><a href="#">Dropdown link</a></li>
			</ul>
		</div>
	</div>
	
	<hr>
	<!-- 垂直排列 -->
	<div class="btn-group-vertical">
		<button type="button" class="btn btn-warning">1</button>
		<button type="button" class="btn btn-warning">2</button>
		<button type="button" class="btn btn-warning">3</button>
		<button type="button" class="btn btn-warning">4</button>
		<button type="button" class="btn btn-warning">5</button>
		<div class="btn-group">
			<button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown" ria-haspopup="true" aria-expanded="false">
				dropdown
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="#">Dropdown link</a></li>
	      		<li><a href="#">Dropdown link</a></li>
			</ul>
		</div>
	</div>
	
	<hr>
	<!-- 两端对齐 -->
	<div class="btn-group btn-group-justified">
		<div class="btn-group">
			<button type="button" class="btn btn-warning">left</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-warning">center</button>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-warning">right</button>
		</div>
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>