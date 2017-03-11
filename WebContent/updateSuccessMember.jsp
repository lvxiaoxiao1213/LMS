<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.lms.entity.User"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBL IC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link href="${ctx}/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<script src="${ctx}/js/jquery-1.10.1.min.js"></script>
<script src="${ctx}/js/side.js" type="text/javascript"></script>
<script type="text/javascript"></script>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
}
a:link,a:visited{
 text-decoration:none;  
}
a:hover{
 text-decoration:underline; 
}
</style>
</head>

<body>
     </br>
     </br>
	<h1 style="font-weight: normal;">修改成功</h1></br></br>
	<a href="${ctx}/UserInfo"><h2>返回</h2></a>

</body>
</html>