<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<!-- ng-app声明Angular的边界,ng-app指令告诉angular应该管理页面中的哪一块 -->
<html ng-app="myApp">
<!-- 这样angular管理页面上的所有DOM元素 -->
<body>
	<form ng-controller="StartUpController">
		Starting:<input ng-change="computeNeeded()"
			ng-model="funding.startingEstimate">
		Recommendation:{{funding.needed}}
	</form>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/angular-1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var myModule = angular.module("myApp",[]);
		myModule.controller("StartUpController",function($scope){
			$scope.funding = {
				startingEstimate : 0
			};

			$scope.computeNeeded = function() {
				$scope.funding.needed = $scope.funding.startingEstimate * 10;
			}
		});
	</script>
</body>
</html>