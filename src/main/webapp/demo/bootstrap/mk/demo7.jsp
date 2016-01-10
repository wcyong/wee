<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>标题（一）</title>
 <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<!--无序列表去点-->
<ul>
    <li>
    项目列表
        <ul>
        <li>带有项目符号</li>
        <li>带有项目符号</li>
        </ul>
    </li>
    <li>
    项目列表
        <ul class="list-unstyled">
        <li>不带项目符号</li>
        <li>不带项目符号</li>
        </ul>
    </li>
    <li>项目列表</li>
</ul>
<!--有序列表去序号-->
<ol>
    <li>
    项目列表
        <ol>
        <li>带有项目编号</li>
        <li>带有项目编号</li>
        </ol>
    </li>
    <li>
    项目列表
        <ol class="list-unstyled">
        <li>不带项目编号</li>
        <li>不带项目编号</li>
        </ol>
    </li>
    <li>项目列表</li>
</ol>
</body>
</html>