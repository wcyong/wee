<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fullwin() {
		window.top.location.href = "${pageContext.request.contextPath}/tab/top";
		return false;
		//            var target = "Frame/MainApp.aspx"
		//                        newwindow = window.open("", "", "scrollbars")
		//                        if (document.all) {
		//                            newwindow.moveTo(0, 0)
		//                            newwindow.resizeTo(screen.width, screen.height)
		//                        }
		//                        newwindow.location = target
		//                        closeWin();
	}
	//关闭当前页面
	function closeWin() {
		window.opener = null;
		window.open('', '_self');
		window.close();
	}
</script>
</head>
<body onload="fullwin()">

</body>
</html>