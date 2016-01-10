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
<h5>普通列表</h5>
<ul>
    <li>列表项目</li>
    <li>列表项目</li>
    <li>列表项目</li>
    <li>列表项目</li>
    <li>列表项目</li>
</ul>
<h5>有序列表</h5>
<ol>
      <li>项目列表一</li>
      <li>项目列表二</li>
      <li>项目列表三</li>
</ol>
<h5>有序列表嵌套</h5>
<ol>
    <li>有序列表</li>
    <li>
    有序列表
        <ol>
        <li>有序列表(2)</li>
        <li>有序列表(2)</li>
        </ol>
    </li>
    <li>有序列表</li>
</ol>
</body>
</html>