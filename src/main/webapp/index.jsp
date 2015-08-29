<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<form action="<%=request.getContextPath()%>/servlet/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="upload"/>
	<input type="submit" value="提交">
</form>
</body>
</html>
