<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>标题（一）</title>
 <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style type="text/css">
    /* 轮播广告 */

     .carousel {
         height: 500px;
         margin-bottom: 60px;
     }

     .carousel .item {
         height: 500px;
         background-color: #000;
     }

     .carousel .item img {
         width: 100%;
     }

     .carousel-caption {
         z-index: 10;
     }

     .carousel-caption p {
         margin-bottom: 20px;
         font-size: 20px;
         line-height: 1.8;
     }
</style>
</head>

<body>
	<!-- 广告轮播 -->
	<div id="ad-carousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
			<li data-target="#ad-carousel" data-slide-to="1"></li>
			<li data-target="#ad-carousel" data-slide-to="2"></li>
			<li data-target="#ad-carousel" data-slide-to="3"></li>
			<li data-target="#ad-carousel" data-slide-to="4"></li>
		</ol>
		 <div class="carousel-inner">
		 	<div class="item active">
	            <img src="images/chrome-big.jpg" alt="1 slide">
	            <div class="container">
	                <div class="carousel-caption">
	                    <h1>Chrome</h1>
	                    <p>Google Chrome，又称Google浏览器，是一个由Google（谷歌）公司开发的网页浏览器。</p>
	                    <p><a class="btn btn-lg btn-primary" href="http://www.google.cn/intl/zh-CN/chrome/browser/"
	                          role="button" target="_blank">点我下载</a></p>
	                </div>
	            </div>
	        </div>
	        
            <div class="item">
	            <img src="images/firefox-big.jpg" alt="2 slide">
	            <div class="container">
	                <div class="carousel-caption">
	                    <h1>Firefox</h1>
	                    <p>Mozilla Firefox，中文名通常称为“火狐”或“火狐浏览器”，是一个开源网页浏览器。</p>
	                    <p><a class="btn btn-lg btn-primary" href="http://www.firefox.com.cn/download/" target="_blank"
	                          role="button">点我下载</a></p>
	                </div>
	            </div>
	        </div>
        
	        <div class="item">
	            <img src="images/safari-big.jpg" alt="3 slide">
	            <div class="container">
	                <div class="carousel-caption">
	                    <h1>Safari</h1>
	                    <p>Safari，是苹果计算机的最新操作系统Mac OS X中的浏览器。</p>
	                    <p><a class="btn btn-lg btn-primary" href="http://www.apple.com/cn/safari/" target="_blank"
	                          role="button">点我下载</a></p>
	                </div>
	            </div>
	        </div>
	        
	        <div class="item">
	            <img src="images/opera-big.jpg" alt="4 slide">
	            <div class="container">
	                <div class="carousel-caption">
	                    <h1>Opera</h1>
	                    <p>Opera浏览器，是一款挪威Opera Software ASA公司制作的支持多页面标签式浏览的网络浏览器。</p>
	                    <p><a class="btn btn-lg btn-primary" href="http://www.opera.com/zh-cn" target="_blank"
	                          role="button">点我下载</a></p>
	                </div>
	            </div>
	        </div>
	        
	        <div class="item">
	            <img src="images/ie-big.jpg" alt="5 slide">
	            <div class="container">
	                <div class="carousel-caption">
	                    <h1>IE</h1>
	                    <p>Internet Explorer，简称 IE，是微软公司推出的一款网页浏览器。</p>
	                    <p><a class="btn btn-lg btn-primary" href="http://ie.microsoft.com/" target="_blank"
	                          role="button">点我下载</a></p>
	                </div>
	            </div>
	        </div>
        
		 </div>
		 
		 <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
            class="glyphicon glyphicon-chevron-left"></span></a>
	    <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
	            class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
</body>
</html>	