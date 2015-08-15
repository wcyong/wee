<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//请求json，输出是json
		$("#requestJson").click(function(){
			$.ajax({
				type:'post',
				url:"${pageContext.request.contextPath}/json/requestJson",
				contentType:'application/json;charset=utf-8',
				//数据格式是json串，用户信息
				data:'{"username":"李四","id":999}',
				success:function(data){//返回json结果
					alert(data.username);
				}
			});
		});
		
		//请求key/value，输出是json
		$("#responseJson").click(function(){
			$.ajax({
				type:'post',
				url:'${pageContext.request.contextPath}/json/responseJson',
				//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
				//contentType:'application/json;charset=utf-8',
				//数据格式是json串，商品信息
				data:'username=手机&id=888',
				success:function(data){//返回json结果
					alert(data.username);
				}
				
			});
		});
	});
</script>
</head>
<body>
<input type="button" id="requestJson" value="请求json，输出是json"/>
<input type="button" id="responseJson" value="请求key/value，输出是json"/>
</body>
</html>