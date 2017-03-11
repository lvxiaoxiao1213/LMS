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

<style>
a:link,a:visited{
 text-decoration:none;  
}
a:hover{
 text-decoration:underline; 
}


</style>


</head>

<body>
<script type="text/javascript">
	/* 修改资料 */
	function update(id){
		$.post('${ctx}/UserUpdate', { "id":id }, function (data) { window.location.reload(true) });
	}
	
	
</script>

<from>

<div class="form_boxC">
<h2 >个人信息:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>
<table>
<tr>
<th>ID</th>
<td><div class="txtbox floatL"><input type="text" id="id"  name="id" placeholder="" readonly="readonly" value="${one.id}"></input></div></td>
</tr>
<tr>
<th>用户名</th>
<td><div class="txtbox floatL"><input type="text" id="name"  name="name" placeholder="" readonly="readonly" value="${user}"></input></div></td>
</tr>
<tr>
<th>用户等级</th>
<td>
<c:if test="${one.role==1}">
        		<div class="txtbox floatL">普通用户</div><div><a value="" onclick="">&nbsp;&nbsp;&nbsp;&nbsp;升级VIP 10元/月</a></div>
       </c:if> 
       <c:if test="${one.role==2}">
        		<div class="txtbox floatL">VIP会员</div>
       </c:if></td>
</tr>
<tr>
<th>邮箱</th>
<td><div class="txtbox floatL"><input type="text" name="email" readonly="readonly" value="${one.email}"></input></div></td>
</tr>
<tr>
<th>身份证</th>
<td><div class="txtbox floatL"><input type="text" name="idcard" readonly="readonly" value="${one.idcard}"></input></div></td>
</tr>
<tr>
<th>联系电话</th>
<td><div class="txtbox floatL"><input type="text" name="tell"  readonly="readonly" value="${one.tell}"></input></div></td>
</tr>
<tr>
<th>地址</th>
<td><div class="txtbox floatL"><input type="text" name="address" readonly="readonly" value="${one.address}"></input></div></td>
</tr>
<tr>
<th></th>
<td><div class="txtbox floatL"><a value="" href="userInfoUpdate.jsp">修改个人信息</a></div>
<td><div  class="txtbox floatL"><a value="" href="passwordUpdate.jsp">修改密码</a></div></td>

</tr>
</table>
</div>
</from>

</body>
</html>