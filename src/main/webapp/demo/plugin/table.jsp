<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表格插件测试</title>
<style type="text/css">
	.mytable {
		border-spacing: 0px;
		border-top: 1px solid #999;
		border-left: 1px solid #999;
		font-size: 12px;
	}
	.mytable td,.mytable th {
		border-right: 1px solid #999;
		border-bottom: 1px solid #999;
		padding: 6px 4px;
	}
	.headBg {
		background:#621;
		color:#fff;
	}
	tr.evenBg {
		background:#bbb;
	}
	tr.hoverBg {
		background:#484;
		color:#fff;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/test/plugin/jquery.table.js"></script>
<script type="text/javascript">
	$(function(){
		$("#mt").mytable({
			width:900,
			onComplete:function(mt,elem){
				//通过mt和elem可以有效的获取相应的参数，这个参数是在mytable内部
				console.log(mt.options.width);
			},
			onTdClick:function(event) {
				var mt = event.data.mt;
				console.log(mt.options.width);
				console.log($(this).html());
			}
		});
	});
</script>
</head>
<body>
	<table id="mt">
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>密码</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
			<tr>
				<td>1</td>
				<td>张三</td>
				<td>1234</td>
			</tr>
		</tbody>
	</table>
</body>
</html>