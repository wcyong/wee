<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title>校验用户输入</title>
<style type="text/css">
    .ng-invalid {
      border-color: red;
    }
</style>
<link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var myModule = angular.module("myApp",[]);
	myModule.controller("AddUserController",function($scope){
		$scope.message = '';
		
		$scope.addUser = function() {
			$scope.message = 'Thanks, ' + $scope.user.first + ', we added you!';
		}
	});
</script>
</head>
<body>
	 <h1>Sign Up</h1>
	 <form name="addUserForm" ng-controller="AddUserController">
	 	<div ng-show="message">{{message}}</div>
	 	<div>First name:<input name="firstName" ng-model="user.first" required></div>
	 	<div>Last name: <input ng-model='user.last' required></div>
	 	<div>Email: <input type='email' ng-model='user.email' required></div>
	 	<div>Age: <input type='number'
                       ng-model='user.age'
                       ng-maxlength='3'
                       ng-min='1'></div>
        <div><button ng-click='addUser()'
                   ng-disabled='!addUserForm.$valid'>Submit</button></div>
	 </form>
</body>
</html>