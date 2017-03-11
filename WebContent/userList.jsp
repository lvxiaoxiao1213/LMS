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
<link href="${ctx}/css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="${ctx}/css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="${ctx}/js/jquery-1.10.1.min.js"></script>
<script src="${ctx}/js/side.js" type="text/javascript"></script>
<script type="text/javascript">
	/* 取消会员资格 */
	function disable(id){
		$.post('${ctx}/UserDisable', { "id":id }, function (data) { window.location.reload(true) });
	}
	/* 恢复会员资格 */
	function enable(id){
		$.post('${ctx}/UserEnable', { "id":id }, function (data) { window.location.reload(true) });
	}
	/* 升级用户 */
	function upgrade(id){
		$.post('${ctx}/UserUpgrade', { "id":id }, function (data) { window.location.reload(true) });
	}
	/* 降级用户 */
	function demotion(id){
		$.post('${ctx}/UserDemotion', { "id":id }, function (data) { window.location.reload(true) });
	}
	/* 删除用户*/
	function del(id){
		$.post('${ctx}/UserDelete', { "id":id }, function (data) { window.location.reload(true) });
	}
</script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>


<div id="MainForm">
<div class="form_boxA">
<h2>用户列表</h2>
<table class="tablelist" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th style="width:5%">编号</th>
<th style="width:8%">用户</th>
<th style="width:10%">邮箱</th>
<th style="width:12%">联系电话</th>
<th style="width:12%">身份证号</th>
<th style="width:15%">地址</th>
<th style="width:10%">权限</th>
<th style="width:10%">状态</th>
<th style="width:18%">操作</th>

</tr>
</thead>
<tbody>
<%
        	String data=(String)request.getAttribute("users");
        	List<User> lists=JSON.parseArray(data, User.class);
        %>
        <c:forEach var="user" items="<%=lists%>">
        <tr>
        <td name="id">${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.tell}</td>
        <td>${user.idcard}</td>
        <td>${user.address}</td>
        <td>
        	<c:if test="${user.role==2}">
        		VIP用户
        	</c:if>
        	<c:if test="${user.role==1}">
        		普通用户
        	</c:if>
        </td>
        <td>
        	<c:if test="${user.status==0 }">
        		活跃用户
        	</c:if>
        	<c:if test="${user.status==1 }">
        		黑名单
        	</c:if>	
        </td>
        <td>
       		<c:if test="${user.status==0 }">
        		<a onclick="disable('${user.id}')" style="color:red">取消会员资格</a>
        	</c:if>
        	<c:if test="${user.status==1 }">
        		<a onclick="enable('${user.id}')" style="color:green">恢复会员资格</a>
        	</c:if>|
        	<c:if test="${user.role==2 }">
        		<a onclick="demotion('${user.id}')" style="color:red">降级</a>
        	</c:if>
        	<c:if test="${user.role==1 }">
        		<a onclick="upgrade('${user.id}')" style="color:green">升级</a>
        	</c:if>|       	
        	<a onclick="del('${user.id}')"> 删除</a>
        	</td>
        
        
        </tr>
        </c:forEach>
</tbody>
</table>

</div>
</div>


</body>
</html>