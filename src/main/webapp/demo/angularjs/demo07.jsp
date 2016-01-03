<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html ng-app="myApp">
<body>
	<form ng-controller="StudentListController">
		<ul>
			<li ng-repeat="student in students">
				{{$index+1}}、<a href="/student/view/{{student.id}}">{{student.name}}</a>
			</li>
		</ul>
		<button ng-click="addItem()">add</button>
	</form>
	
	
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		var students = [{name:"wwss",id:1},
		                {name:"jack",id:2},
		                {name:"lee",id:3}];
		myModule.controller("StudentListController",function($scope){
			$scope.students= students;
			
			$scope.addItem = function() {
				$scope.students.splice(1,0,{name:"tom",id:4});
			}
		});
	</script>
</body>
</html>