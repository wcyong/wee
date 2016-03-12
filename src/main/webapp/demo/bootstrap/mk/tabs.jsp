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
</style>
</head>

<body>
<ul class="nav nav-tabs" role="tablist" id="feature-tab">
        <li class="active"><a href="#tab-chrome" role="tab" data-toggle="tab">Chrome</a></li>
        <li><a href="#tab-firefox" role="tab" data-toggle="tab">Firefox</a></li>
        <li><a href="#tab-safari" role="tab" data-toggle="tab">Safari</a></li>
        <li><a href="#tab-opera" role="tab" data-toggle="tab">Opera</a></li>
        <li><a href="#tab-ie" role="tab" data-toggle="tab">IE</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="tab-chrome">
            <div class="row feature">
                <div class="col-md-7">

                    <h2 class="feature-heading">Google Chrome <span
                            class="text-muted">使用最广的浏览器</span></h2>

                    <p class="lead">Google Chrome，又称Google浏览器，是一个由Google（谷歌）公司开发的网页浏览器。
                        该浏览器是基于其他开源软件所撰写，包括WebKit，目标是提升稳定性、速度和安全性，并创造出简单且有效率的使用者界面。</p>
                </div>
                <div class="col-md-5">
                    <img class="feature-image img-responsive" src="images/chrome-logo.jpg"
                         alt="Chrome">
                </div>
            </div>
        </div>
        <div class="tab-pane" id="tab-firefox">
            <div class="row feature">
                <div class="col-md-5">
                    <img class="feature-image img-responsive" src="images/firefox-logo.jpg"
                         alt="Firefox">
                </div>
                <div class="col-md-7">

                    <h2 class="feature-heading">Mozilla Firefox <span class="text-muted">美丽的狐狸</span>
                    </h2>

                    <p class="lead">Mozilla Firefox，中文名通常称为“火狐”或“火狐浏览器”，是一个开源网页浏览器，
                        使用Gecko引擎（非ie内核），支持多种操作系统如Windows、Mac和linux。</p>
                </div>
            </div>
        </div>
        <div class="tab-pane" id="tab-safari">
            <div class="row feature">
                <div class="col-md-7">

                    <h2 class="feature-heading">Safari <span class="text-muted">Mac用户首选</span></h2>

                    <p class="lead">Safari，是苹果计算机的最新操作系统Mac OS X中的浏览器，使用了KDE的KHTML作为浏览器的运算核心。
                        Safari在2003年1月7日首度发行测试版，并成为Mac OS X v10.3与之后的默认浏览器，也是iPhone与IPAD和iPod touch的指定浏览器。</p>
                </div>
                <div class="col-md-5">
                    <img class="feature-image img-responsive" src="images/safari-logo.jpg"
                         alt="Safari">
                </div>
            </div>
        </div>
        <div class="tab-pane" id="tab-opera">
            <div class="row feature">
                <div class="col-md-5">
                    <img class="feature-image img-responsive" src="images/opera-logo.jpg"
                         alt="Opera">
                </div>
                <div class="col-md-7">

                    <h2 class="feature-heading">Opera <span class="text-muted">小众但易用</span>
                    </h2>

                    <p class="lead">Opera浏览器，是一款挪威Opera Software ASA公司制作的支持多页面标签式浏览的网络浏览器。
                        是跨平台浏览器可以在Windows、Mac和Linux三个操作系统平台上运行。.</p>
                </div>
            </div>
        </div>
        <div class="tab-pane" id="tab-ie">
            <div class="row feature">
                <div class="col-md-7">

                    <h2 class="feature-heading">IE <span class="text-muted">你懂的</span></h2>

                    <p class="lead">Internet Explorer，原称Microsoft Internet Explorer(6版本以前)和Windows Internet
                        Explorer(7，8，9，10版本)，
                        简称IE，是美国微软公司推出的一款网页浏览器。它采用的排版引擎(俗称内核)为Trident。</p>
                </div>
                <div class="col-md-5">
                    <img class="feature-image img-responsive" src="images/ie-logo.jpg"
                         alt="IE">
                </div>
            </div>
        </div>
    </div>
</body>
</html>	