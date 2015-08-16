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
  
  	<!-- 下拉菜单 -->
  	<div class="dropdown">
  		<button class="btn btn-success dropdown-toggle"  type="button" id="dropdownMenu1" 
  		data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">dropdown&nbsp;&nbsp;
  		<span class="caret"></span>
  		</button>
  		
  		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
  			<!-- 下拉选项标题 -->
  			<li class="dropdown-header">dropdown header</li>
  			<li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <!-- 分隔线 -->
		    <li role="separator" class="divider"></li>
		    <li><a href="#">Something else here</a></li>
		    <!-- 禁用下拉选项 -->
		    <li class="disabled"><a href="#">Separated link</a></li>
  		</ul>
  	</div>
  	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>