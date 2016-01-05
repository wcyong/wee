<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title></title>
<link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var myModule = angular.module("myApp",[]);
	myModule.controller("SomeController",function($scope){
		$scope.message = {text:'nothing clicked yet'};
		
		$scope.clickUnfocused = function() {
			$scope.message.text = "unfocused button clicked";
		}
		
		$scope.clickFocused = function() {
			$scope.message.text = "focus button clicked";
		}
	});
	
	myModule.directive("ngbkFocus",function(){
		return {
			link:function(scope,element,attrs,controller) {
				element[0].focus();	
			}
		};
	});
</script>
</head>
<body ng-controller="SomeController">
	<button ng-click="clickUnfocused()">Not focused!</button>
	<button ngbk-focus ng-click="clickFocused()">I'am very focused!</button>
	<div>{{message.text}}</div>
</body>
</html>