<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ip = request.getRemoteAddr();
	String ip2 = request.getLocalAddr();
%>
<html>
<body>
<h2>Hello World!</h2>
	<h1>
		<%=ip %><br>
		<%=ip2 %>
	</h1>
</body>
</html>
