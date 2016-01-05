<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title>与服务器交互</title>
<link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var userModule = angular.module("myApp",[]);
	userModule.controller("UserController",function($scope,$http){
		$http.get("<%=request.getContextPath()%>/angular/testDatas").success(function(data,status,headers,config){
			$scope.users = data;
		});
	});
</script>
</head>
<body ng-controller="UserController">
	<h1>User demo</h1>
	<table class="table table-bordered">
		<tr ng-repeat="user in users">
			<td>{{user.id}}</td>
			<td>{{user.usernmae}}</td>
			<td>{{user.birthday}}</td>
			<td>{{user.sex}}</td>
			<td>{{user.address}}</td>
		</tr>
	</table>
</body>
</html>