<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="add">添加</a><a href="publishMenu">发布</a>
	<table width="900px" border="1" align="center">
	<tr>
		<td>ID</td><td>name</td><td>key</td><td>url</td><td>content</td><td>type</td><td>pid</td>
	</tr>
		<c:forEach items="${menus }" var="menu">
			<tr>
				<td>${menu.id }</td>
				<td>${menu.name }[<a href="update/${menu.id }">更新</a>&nbsp;<a href="delete/${menu.id }">删除</a>]</td>
				<td>${menu.menuKey}</td>
				<td>${menu.url }</td>
				<Td>${menu.content }</Td>
				<td>${menu.type }[${menu.respType }]</td>
				<td>${menu.pid}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>