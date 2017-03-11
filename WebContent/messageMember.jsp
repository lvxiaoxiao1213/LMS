<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON" %>
<%@page import="com.lms.entity.Message"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<script type="text/javascript">
	/* 查看消息 */
	function read(messageId){
		$.post('${ctx}/MessageRead', { "messageId":messageId }, function (data) { window.location.reload(true) });
	}
</script>
<%
      String data=(String)request.getAttribute("messages");
	  String data2=(String)request.getAttribute("user");
      List<Message> lists=JSON.parseArray(data, Message.class);
%>
<!-- MainForm -->
<div id="MainForm">
<div class="form_boxA">
<h2>消息列表</h2>
<table class="tablelist" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th>消息编号</th>
<th>发送方</th>
<th>发送内容</th>
<th>接收时间</th>
<th>消息状态</th>
<th>操作</th>
</tr>
</thead>
<tbody var="user" items="<%=data2%>">

<c:forEach var="message" items="<%=lists%>">
<c:if test="${message.userName==user}">
<tr>
<td name="messageId">${message.messageId}</td>
<td>admin</td>
<td>${message.messageContent}</td>
<td><fmt:formatDate value="${message.messageTime}"
									pattern="yyyy-MM-dd" /></td>
<td> <c:if test="${message.ifread==0}">
        		未读
       </c:if>
       <c:if test="${message.ifread==1}">
        		已读
       </c:if></td>
<td><a onclick="read('${message.messageId}')">查看</a></td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>

</div>
</div>
<!-- /MainForm -->

</body>
</html>