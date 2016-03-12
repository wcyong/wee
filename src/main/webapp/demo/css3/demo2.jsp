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
   	/*  box-shadow: X轴偏移量 Y轴偏移量 [阴影模糊半径] [阴影扩展半径] [阴影颜色] [投影方式]; */
    	.s1 {
    		width:100px;
    		height:100px;
    		border: 1px solid;
    		box-shadow:4px 2px 6px #333333;
    	}
    	
    	/* 内阴影 */
    	.s2 {
    		width: 100px;
    		height: 100px;
    		border: 1px solid;
    		box-shadow:4px 2px 6px #333333 inset;
    	}
    	
    	.s3 {
    		width: 100px;
    		height: 100px;
    		border: 1px solid;
    		box-shadow:4px 2px 6px #f00, -4px -2px 6px #000, 0px 0px 12px 5px #33CC00 inset;
    	}
    </style>
  </head>

 <body>
 	<div class="s1"></div>
 	<div class="s2"></div>
 	<div class="s3"></div>
 	<div class="s4"></div>
 </body>
</html>