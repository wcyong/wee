<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 显示错误信息 -->
<c:if test="${allErrors!=null }">
	<c:forEach items="${allErrors }" var="error">
		${ error.defaultMessage}<br/>
	</c:forEach>
</c:if>
	<form action="${pageContext.request.contextPath }/user/update/${user.id}" method="post" enctype="multipart/form-data">
	<table width="500px" border="1">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="username" value="${user.username }"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><input type="text" name="sex" value="${user.sex }"></td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td>
			<input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"/>
			</td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" name="address" value="${user.address }"></td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<c:if test="${user.pic != null}">
					<img src="${pageContext.request.contextPath }/resources/pic/${user.pic}" width=100 height=100/>
					<br/>
				</c:if>
				<input type="file" name="user_pic"/> 
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
	</form>
</body>
</html>