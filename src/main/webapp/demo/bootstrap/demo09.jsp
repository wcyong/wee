<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Starter Template for Bootstrap</title>

    <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

  </head>

  <body>
  
  	<form class="form-inline">
  		<div class="form-group">
  			<label for="exampleInputName2">Name</label>
    		<input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
  		</div>
  		
  		<div class="form-group">
  			<div class="input-group">
  				<div class="input-group-addon">@</div>
  				<input type="text" class="form-control" placeholder="enter email">
  			</div>
  		</div>
  		
  		<div class="form-group">
  			<label class="sr-only" for="exampleInputPassword3">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
  		</div>
  		
  		<div class="checkbox">
	    <label>
	      <input type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-default">Sign in</button>
  	</form>
  	
  	
  	<hr>
  	
  	<form class="form-horizontal">
  		<div class="form-group">
  			<label for="exampleInputName2">Name</label>
    		<input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
  		</div>
  		
  		<div class="form-group">
  			<div class="input-group">
  				<div class="input-group-addon">@</div>
  				<input type="text" class="form-control" placeholder="enter email">
  			</div>
  		</div>
  		
  		<div class="form-group">
  			<label class="sr-only" for="exampleInputPassword3">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
  		</div>
  		
  		<div class="checkbox">
	    <label>
	      <input type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-default">Sign in</button>
  	</form>
  

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
  </body>
</html>