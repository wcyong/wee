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
	
	<button type="button" class="btn btn-default" id="myPopover">猛击我吧</button>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#myPopover").popover({
			title:"我是弹出框的标题",
		     content:"我是弹出框的内容",
		     placement:"right"
		});
	</script>
</body>
</html>	