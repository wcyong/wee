<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<table cellpadding="0" cellspacing="0">
		<tr>
		<td>名称</td>
		<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>content</td>
		<td><input type="text" name="content"></td>
		</tr>
		<tr>
		<td>url</td>
		<td><input type="text" name="url"></td>
		</tr>
		<tr>
		<td>type</td>
		<td><input type="text" name="type"></td>
		</tr>
		<tr>
		<td>响应类型</td>
		<td><input type="text" name=""></td>
		</tr>
		<tr>
		<td>pid</td>
		<td><input type="text" name="pid"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit"/></td>
		</tr>
		</table>
	</form>
</body>
</html>