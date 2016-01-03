<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title>title</title>
	<style type="text/css">
		.menu-disaled-true {
			color:red;
		}
	</style>
</head>
<body>
	<div ng-controller="DeathrayMenuController">
		<button ng-click="toggleMenu()">Toggle Menu</button>
		<ul ng-show="menuState">
			<li ng-click="stun()" class="menu-disaled-{{isDisabled}}">Stun</li>
			<li ng-click="disintegrate()" style="{{someexpression}}">Disintegrate</li>
			<li ng-click="erase()">Erase</li>
		</ul>
	</div>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		myModule.controller("DeathrayMenuController",function($scope){
			$scope.menuState = false;
			$scope.isDisabled = false;
			
			$scope.toggleMenu = function(){
				$scope.menuState = !$scope.menuState;
			}
			$scope.stun = function(){
				$scope.isDisabled = true;
			}
			$scope.disintegrate = function(){
				$scope.someexpression = "background:green;";
			}
			$scope.erase = function(){
				alert("erase()");
			}
		});
	</script>
</body>
</html>