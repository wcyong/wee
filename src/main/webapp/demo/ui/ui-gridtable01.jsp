<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GridTable demo</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ui/bootstrap-custom.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<table>
			<tr>
				<td>
					<button type="button" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"></span> 添加</button>
					<button type="button" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
					<button type="button" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"></span> 删除</button>
				</td>
			</tr>
		</table>
		<table class="table table-bordered table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<td>1</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@TwBootstrap</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Larry the Bird</td>
					<td>@twitter</td>
					<td>@twitter</td>
				</tr>
				<tr>
					<td>1</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Mark</td>
					<td>Otto</td>
					<td>@TwBootstrap</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Jacob</td>
					<td>Thornton</td>
					<td>@fat</td>
				</tr>
				<tr>
					<td>3</td>
					<td>测试测试测试测试测试测试</td>
					<td>@twitter</td>
					<td>@twitter</td>
				</tr>
			</tbody>
		</table>


		<ul class="pagination nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">10 <b class="caret"></b></a>
				<ul class="dropdown-menu" style="min-width: 50px;">
					<li><a href="#">10</a></li>
					<li><a href="#">20</a></li>
					<li><a href="#">30</a></li>
					<li><a href="#">50</a></li>
				</ul></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-fast-backward"></span></a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-backward"></span></a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li class="active"><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-forward"></span></a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-fast-forward"></span></a></li>
			<li>
				<div class="input-group">
					<input type="text" style="border-radius: 0px;height: 31px;"
						class="form-control text-center" size="2" placeholder="3">
				</div>
			</li>
			<li><a href="#">GO</a></li>
		</ul>
		<p class="navbar-text pull-right" style="vertical-align: middle;">每页显示10条
			共5页 50条记录</p>
	</div>
	
</body>
</html>