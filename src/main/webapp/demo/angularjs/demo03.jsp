<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<!-- ng-app声明Angular的边界,ng-app指令告诉angular应该管理页面中的哪一块 -->
<html ng-app="myApp"><!-- 这样angular管理页面上的所有DOM元素 -->
<body ng-controller="TextController">
	<!-- 双花括号插值语法,它可以把新的内容插入到现有的模板中 -->
	<p>{{someText.message}}</p>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		/* 
			我们把ng-app属性设置成为模块的名称myApp,然后，我们再调用angular对象创建了一个名为myApp
			的模块，并且把控制器函数传递给了myApp模块的controller函数
			
		*/
		var myAppModule = angular.module('myApp',[]);
		myAppModule.controller("TextController",function($scope) {
			var someText = {};
			someText.message = "you have started your journey";
			$scope.someText = someText;
		});
	</script>
</body>
</html>