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
	<div style="text-align: center;">
		<button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="left" data-original-title="提示框居左" title="">提示框居左</button>
		<button type="button" 
          class="btn btn-default" 
          data-toggle="tooltip" 
          data-placement="top" 
          data-original-title="提示框在顶部">
   提示框在顶部
  </button>
  <button type="button" 
          class="btn btn-default" 
          data-toggle="tooltip" 
          data-placement="bottom" 
          data-original-title="提示框在底部">
  提示框在底部             
  </button>
  <button type="button" 
          class="btn btn-default" 
          data-toggle="tooltip" 
          data-placement="right" 
          data-original-title="提示框居右">
  提示框居右      
  </button>
  <h3>链接制作的提示框</h3>
  <a class="btn btn-primary" 
     data-toggle="tooltip" 
     data-placement="left" 
     title="提示框居左">
     提示框居左
  </a>
  <a class="btn btn-primary" 
     data-toggle="tooltip" 
     data-placement="top" 
     title="提示框在顶部">
     提示框在顶部
  </a>
  <a class="btn btn-primary" 
     data-toggle="tooltip" 
     data-placement="bottom" 
     title="提示框在底部">
     提示框在底部
  </a>
  <a class="btn btn-primary" 
     data-toggle="tooltip" 
     data-placement="right" 
     title="提示框在居右">
     提示框居右
  </a>
  <a href="##" 
     class="btn btn-primary" 
     id="myTooltip">
     我是提示框
  </a>
  <a href="##" 
     class="btn btn-primary" 
     id="myTooltip2">
     我是提示框2
  </a>
	</div>
	</form>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script>
  $(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('#myTooltip').tooltip({
        title:"我是一个提示框，我在顶部出现",
        placement:'top'
      });
  });
  </script>
</body>
</html>	