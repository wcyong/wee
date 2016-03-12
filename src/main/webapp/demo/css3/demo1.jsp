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
    <title>css3</title>
    <style type="text/css">
    	/* 所有角都使用半径为10px的圆角 */ 
    	.r1 {
    		border-radius:10px;
    		border: 1px solid;
    		height: 100px;
    		width: 100px;
    	}
    	
    	/* 四个半径值分别是左上角、右上角、右下角和左下角，顺时针 */ 
    	.r2 {
    		width: 100px;
    		height: 100px;
    		border: 1px solid;
    		border-radius:5px 4px 3px 2px;
    	}
    	
    	.r3 {
    		width: 100px;
    		height: 50px;
    		border: 1px solid;
    		border-radius:50px 50px 0 0;
    	}
    	
    	.r4 {
    		width: 100px;
    		height: 100px;
    		border: 1px solid;
    		border-radius:50px;
    		background: #9da;
    	}
    </style>
  </head>

 <body>
 	<div class="r1"></div>
 	<div class="r2"></div>
 	<div class="r3"></div>
 	<div class="r4"></div>
 </body>
</html>