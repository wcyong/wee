<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GridTable demo</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/ui/css/bootstrap-custom.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ui/js/jquery.auk.dialog.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.mydialog("hello world");
		});
		/* $("#btn").click(function(){
			var d = dialog({
			    title: '欢迎',
			    content: '欢迎使用 artDialog 对话框组件！'
			});
			d.show();
		}); */
		/* $("#btn").click(function(){
			skynetDialog.alert("aaaa");
		}); */
	});
	
	/**
	 * 基础URL
	 */
	function getBaseUrl() {
	   var cPath = window.document.location.href,
        pathName = window.document.location.pathname,
        localPath = cPath.substring(0, cPath.indexOf(pathName)),
        projectName = pathName.substring(0, pathName.substr(1).indexOf("/") + 1),
        rootPath = localPath + projectName;
	   
	    return projectName;
	}
	/**
	 * 简单类型空验证
	 * @param obj
	 */
	function isEmpty(obj) {
	    if (obj == undefined || obj == null) {
	        return true;
	    }
	    if (typeof(obj) == "string") {
	        if (obj.trim().length > 0) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	    if (typeof(obj) === "number") {
	        return false;
	    }
	    if (typeof(obj) === "boolean") {
	        return false;
	    }
	    if (typeof(obj) === "function") {
	        return false;
	    }
	    if (obj instanceof Array && obj.length < 1) {
	        return true;
	    }
	    if (obj instanceof HTMLElement) {
	        return false;
	    }
	    if (obj['jquery'] && obj['jquery'] != null && obj['jquery'] != "" && obj.context instanceof Document) {
	        if (typeof(obj.length) === "number" && obj.length < 1) {
	            return true;
	        }
	    }
	    if (obj instanceof Object) {
	        var cnt = 0;
	        for (var t in obj) {
	            if (!t || t == null) continue;
	            if (!obj.hasOwnProperty(t)) continue;
	            cnt++;
	            if (cnt > 0) break;
	        }
	        if (cnt > 0) {
	            return false;
	        } else {
	            return true;
	        }
	    }
	};
</script>
</head>
<body>
<div id="div1">aaaaa</div>
<input type="button" id="btn" value="open">
</body>
</html>