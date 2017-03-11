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

<form action="${ctx}/UserUpdate" method="post">

<div class="form_boxC">
<table>
<tr>
<th>ID</th>
<td><div class="txtbox floatL"><input id="id" name="id" type="text" readonly="readonly" placeholder="" size="40" value="${one.id}"></div></td>
</tr>
<tr>
<th>用户名</th>
<td><div class="txtbox floatL"><input id="name" name="name" type="text" readonly="readonly" placeholder="" size="40"  value="${user}"></div></td>
</tr>
<tr>
<th>邮箱</th>
<td><div class="txtbox floatL"><input id="email" name="email" name="" type="text"  size="40" value="${one.email}"/></div></td>
</tr>
<tr>
<th>身份证</th>
<td><div class="txtbox floatL"><input id="idcard" name="idcard" type="text" readonly="readonly"  size="40" value="${one.idcard}"/></div></td>
</tr>
<tr>
<th>联系方式</th>
<td><div class="txtbox floatL"><input id="tell" name="tell" type="text"  size="40" value="${one.tell}"/></div></td>
</tr>
<tr>
<th>地址</th>
<td><div class="txtbox floatL"><input id="address" name="address" type="text"  size="40" value="${one.address}"/></div></td>
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