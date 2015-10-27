<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var arr = ["A","B","C","D","E","F","G"];
		var html = "<tr>";
		for(var i=0;i<arr.length; i++) {
			html += "<td>"+arr[i]+"</td>";
			if((i+1) % 2 == 0) {
				html += "</tr></tr>";
			}
		}
		html += "</tr>";
		html +="<tr><td colspan='2'>哈哈</td></tr>";
		$("#tb").append(html);
	});
</script>
</head>
<body>
<table width="700" border="1" cellpadding="0" cellspacing="0" id="tb">

</table>
</body>
</html>