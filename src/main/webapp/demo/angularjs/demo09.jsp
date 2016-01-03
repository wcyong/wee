<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title>title</title>
	<style type="text/css">
		.error {
			background: red;
		}
		.warning {
			background-color: yellow;
		}
	</style>
</head>
<body>
	<div ng-controller="HeaderController">
		<div ng-class="{error:isError,warning:isWarning}">{{messageText}}</div>
		<button ng-click="showError()">Error</button>
		<button ng-click="showWarning()">warning</button>
	</div>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		myModule.controller("HeaderController",function($scope){
			$scope.isError = false;
			$scope.isWarning = false;
			
			$scope.showError = function() {
				$scope.isError = true;
				$scope.isWarning = false;
				$scope.messageText="this is an error";
			}
			
			$scope.showWarning = function() {
				$scope.isError = false;
				$scope.isWarning = true;
				$scope.messageText="just a warning";
			}
		});
	</script>
</body>
</html>