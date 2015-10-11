<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页demo</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/ui/css/bootstrap-custom.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
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
					class="glyphicon glyphicon-step-backward"></span></a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li class="active"><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-step-forward"></span></a></li>
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

	<hr>

	<div class="container">
		<ul class="pagination pagination-sm nav navbar-nav">
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
					class="glyphicon glyphicon-step-backward"></span></a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li class="active"><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-step-forward"></span></a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-fast-forward"></span></a></li>
			<li>
				<div class="input-group input-group-sm">
					<input type="text" style="border-radius: 0px;"
						class="form-control text-center" size="2" placeholder="3">
				</div>
			</li>
			<li><a href="#">GO</a></li>
		</ul>
		<p class="navbar-text pull-right">每页显示10条 共5页 50条记录</p>
	</div>

	<hr>

	<div class="container">
		<ul class="pagination pagination-lg nav navbar-nav">
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
					class="glyphicon glyphicon-step-backward"></span></a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li class="active"><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-step-forward"></span></a></li>
			<li><a href="#"><span
					class="glyphicon glyphicon-fast-forward"></span></a></li>
			<li>
				<div class="input-group input-group-lg">
					<input type="text" style="border-radius: 0px;"
						class="form-control text-center" size="2" placeholder="3">
				</div>
			</li>
			<li><a href="#">GO</a></li>
		</ul>
		<p class="navbar-text pull-right">每页显示10条 共5页 50条记录</p>
	</div>
</body>
</html>