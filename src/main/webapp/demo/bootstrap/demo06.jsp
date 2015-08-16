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
  	
  	<!-- 分离式下拉菜单 -->
  	<div class="btn-group">
		<button type="button" class="btn btn-danger">default</button>
		<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="caret"></span>
    		<span class="sr-only">Toggle Dropdown</span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li role="separator" class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		</ul>
  	</div>
  	
  	<!-- 设置分离式菜单尺寸 -->
  	<div class="btn-group">
		<button type="button" class="btn btn-danger btn-lg">default</button>
		<button type="button" class="btn btn-danger btn-lg dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="caret"></span>
    		<span class="sr-only">Toggle Dropdown</span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li role="separator" class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		</ul>
  	</div>
  	
  	<br><br><br><br><br><br><br>
  	
  	<!-- 向上弹出式菜单 -->
  	<div class="btn-group dropup">
		<button type="button" class="btn btn-danger">default</button>
		<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="caret"></span>
    		<span class="sr-only">Toggle Dropdown</span>
		</button>
		<ul class="dropdown-menu">
			<li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li role="separator" class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		</ul>
  	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>