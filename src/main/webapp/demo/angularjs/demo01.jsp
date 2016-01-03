<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<!-- ng-app声明Angular的边界,ng-app指令告诉angular应该管理页面中的哪一块 -->
<html ng-app="myApp"><!-- 这样angular管理页面上的所有DOM元素 -->
<body ng-controller="TextController">
	<!-- 双花括号插值语法,它可以把新的内容插入到现有的模板中 -->
	<p>{{someText}}</p>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular-route.min.js"></script>
	
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		myModule.controller("TextController",function($scope){
			$scope.someText = "you have started your journey.";
		});
	</script>
</body>
</html>