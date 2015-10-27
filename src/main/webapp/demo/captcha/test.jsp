<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<label for="captcha">验证码：</label>
	<span> <img src="<%=request.getContextPath()%>/captcha.svl"
		onclick="this.src='<%=request.getContextPath()%>/captcha.svl?d='+new Date()"
		class="code" alt="换一张" /><a href="javascript:void(0);"
		onclick="$('.code').attr('src','<%=request.getContextPath()%>/captcha.svl?d='+new Date())"
		title="换一张">换一张</a>
</body>
</html>