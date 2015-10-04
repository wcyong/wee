<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页demo</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	var name = "tm";
	$(function() {
		/* var obj = {
			name : "ws",
			show : function() {
				alert(this.name);//this --->obj
			}
		}
		obj.show(); */
		
		/* var obj = {
			name : "ws",
			show : function() {
				var f = function() {
					alert(this.name);//this --->window
				}
				f();
			}
		}
		obj.show(); */
		
	});
</script>
</head>
<body>
</body>
</html>