<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>标题（一）</title>
 <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<style>
        body{padding:10px;margin:10px;}
    </style>
</head>

<body>
<div id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
           <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
           <li data-target="#myCarousel" data-slide-to="1"></li>
           <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="http://images3.c-ctrip.com/rk/201407/ll580x145.jpg" alt="">
                <div class="carousel-caption">
                  <h4>标题一</h4>
                  <p>图片一内容简介</p>
                </div>
            </div>
            <div class="item">
                <img src="http://images3.c-ctrip.com/dj/201408/zj/zj_580145.jpg" alt="">
                <div class="carousel-caption">
                   <h4>标题二</h4>
                   <p>图片二内容简介</p>
                </div>
            </div>
            <div class="item">
            	<img src="http://images3.c-ctrip.com/rk/201403/yfdd580145a.png" alt="">
                <div class="carousel-caption">
                  <h4>标题三</h4>
                  <p>图片三内容简介</p>
                </div>
            </div>
      </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
	<script>
    $('.carousel').carousel()
    </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</body>
</html>	