<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date s = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String day = sdf.format(s);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/resources/My97DatePicker/skin/WdatePicker.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#startDate").val("20160208");
			$("#startDate").attr("onfocus", "WdatePicker({skin:'whyGreen',dateFmt:'yyyyMM'})");
		});
	</script>
</head>
<body>
	<div>
		<p>
			<input type="text" class="Wdate" id="d122"
				onfocus="WdatePicker({isShowWeek:true,onpicked:function(){$dp.$('d122_1').value=$dp.cal.getP('W','W');}})"
				realvalue="2016-02-17"> &nbsp;&nbsp; 您选择了第 <input
				type="text" id="d122_1" size="3">
		</p>
		<p>
		<input type="text" class="Wdate" id="startDate" value='<%=day%>' onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyyMMdd'})"/>
	</div>
</body>
</html>