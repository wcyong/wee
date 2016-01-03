<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<head>
	<title>title</title>
	<style type="text/css">
		.selected {
			background-color: red;
		}
	</style>
</head>
<body>
	<table ng-controller="RestaurantTableController">
		<tr ng-repeat="restaurant in directory" ng-click="selectRestaurant($index)" ng-class="{selected:$index==selectedRow}">
			<td>{{$index+1}}</td>
			<td>{{restaurant.name}}</td>
			<td>{{restaurant.cuisine}}</td>			
		</tr>
	</table>
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		myModule.controller("RestaurantTableController",function($scope){
			$scope.directory = [{name:"the handsome heifer",cuisine:"BBQ"},
			                    {name:"Green's green greens",cuisine:"Salads"},
			                    {name:"House of fine fish",cuisine:"Seafood"}];
			$scope.selectRestaurant = function(row) {
				$scope.selectedRow = row;
			} 
		});
	</script>
</body>
</html>