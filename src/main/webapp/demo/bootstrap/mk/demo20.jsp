<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>标题（一）</title>
 <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>

<body>
	<form role="form">
		<div class="btn-group">
			<button type="button" class="btn btn-primary">首页</button>
			<button type="button" class="btn btn-default">产品展示</button>
			<button type="button" class="btn btn-default">案例分析</button>
			<button type="button" class="btn btn-default">联系我们</button>
			<div class="btn-group">
		      	<button class="btn btn-default dropdown-toggle" data-toggle="dropdown" type="button">关于我们<span class="caret"></span></button>
			    <ul class="dropdown-menu">
			    	<li><a href="##">公司简介</a></li>
			    	<li><a href="##">企业文化</a></li>
			    	<li><a href="##">组织结构</a></li>
			    	<li><a href="##">客服服务</a></li>
			    </ul>
		  </div>
		</div>
	</form>
</body>
</html>	