<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function batchdel() {
		document.listForm.action = "${pageContext.request.contextPath}/user/deleteBatch";
		document.listForm.submit();
	}
</script>
</head>
<body>
<form name="listForm" action="" method="post">
	<table width="100%" border="1">
		<tr>
			<td>
				<input type="button" value="批量删除" onclick="batchdel()">
			</td>
			<td colspan="5">
				<select name="userType">
					<c:forEach items="${userType }" var="type">
						<option value="${type.key }">${type.value }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>ID</td><td>姓名</td><td>性别</td><td>生日</td><td>地址</td><td>操作</td>
		</tr>
		<c:forEach items="${users }" var="u">
			<tr>
				<td><input type="checkbox" name="ids" value="${u.id }"></td>
				<td>${u.id }</td>
				<td>${u.username }</td>
				<td>${u.sex }</td>
				<td><fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd"/></td>
				<td>${u.address }</td>
				<td><a href="${pageContext.request.contextPath }/user/update/${u.id}">修改</a>
				&nbsp;&nbsp;<a href="#">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>