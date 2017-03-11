<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON" %>
<%@page import="com.lms.entity.User"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBL IC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="generator" content="" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="${ctx}/css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="${ctx}/js/jquery-1.10.1.min.js"></script>
<script src="${ctx}/js/side.js" type="text/javascript"></script>
<script type="text/javascript"></script>
</head>

<body>

<form action="${ctx}/UserPwd" method="post">

<div class="form_boxC">
<table>
<tr>
<th>旧密码</th>
<td><div class="txtbox floatL"><input name="oldpassword" type="password"  size="40"></div></td>
</tr>
<tr>
<th>新密码</th>
<td><div class="txtbox floatL"><input  name="newpassword"  type="password"  size="40"/></div></td>
</tr>
<tr>
<th>确认密码</th>
<td><div class="txtbox floatL"><input name="newpasswordconfirm" type="password"   size="40"/></div></td>
</tr>

<tr>
<th></th>
<td><div class="txtbox floatL"><input  type="submit" value="修改"/></div></td>
</tr>

</table>
</div>
</form>

</body>
</html>