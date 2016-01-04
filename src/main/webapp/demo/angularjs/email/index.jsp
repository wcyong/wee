<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="amail">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular-route.min.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/demo/angularjs/email/controller.js"></script> --%>
<script type="text/javascript">
//为核心的AMail服务创建模块
var aMailServices = angular.module('amail',['ngRoute']);

var messages = [{
	id:0,sender:"675600929@qq.com",subject:"坚持运动",date:"2015-01-01",
	recipients:["aaa@hotmail.com"],
	message:"hey,we should get together for lunch sometime and catch up."
},{
	id:1,sender:"ynljwcy@gmail.com",subject:"认真学习",date:"2015-01-2",
	recipients:["bbb@hotmail.com"],
	message:"i thought you were going to put it in my desk drawer."
},{
	id:2,sender:"ynljwcy@hotmail.com",subject:"来一场说走就走的旅行",date:"2015-01-03",
	recipients:["ccc@hotmail.com"],
	message:"Nobody panic,but my pet python is missing from her cage."
}];

aMailServices.controller("ListController",function($scope){
	$scope.messages = messages;
});

aMailServices.controller("DetailController",function($scope,$routeParams){
	$scope.message = messages[$routeParams.id];
});

//在URL、模板和控制器之间建立映射关系
//配置我们的路由，以便AMail服务能够找到它
aMailServices.config(function($routeProvider){
	$routeProvider.when('/', {
      controller: "ListController",
      templateUrl: 'list.jsp'
    }).when('/view/:id', {
      controller: "DetailController",
      templateUrl: 'detail.jsp'
    }).otherwise({
      redirectTo: '/'
    });
});
</script>
</head>
<body>
	<h1>a-mail</h1>
	<div ng-view></div>
</body>
</html>