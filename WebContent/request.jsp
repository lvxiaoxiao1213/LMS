<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.lms.entity.Request"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="${ctx}/css/haiersoft.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link href="${ctx}/css/print.css" rel="stylesheet" type="text/css"
	media="print" />
<script src="${ctx}/js/jquery-1.10.1.min.js"></script>
<script src="${ctx}/js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
	<script type="text/javascript">
		/* 请求挂起 */
		function ignore(requestId) {
			$.post('${ctx}/RequestIgnore', {
				"requestId" : requestId
			}, function(data) {
				window.location.reload(true)
			});
		}
		/* 请求拒绝 */
		function reject(requestId) {
			$.post('${ctx}/RequestReject', {
				"requestId" : requestId
			}, function(data) {
				window.location.reload(true)
			});
		}
		/* 请求批准借书 */
		function admit(requestId, userName, bookName) {
			$.post('${ctx}/RequestAdmit', {
				"requestId" : requestId,
				"userName" : userName,
				"bookName" : bookName
			}, function(data) {
				window.location.reload(true)
			});
		}
	</script>

	<!-- MainForm -->
	<div id="MainForm">
		<div class="form_boxA">
			<h2>请求管理</h2>
			<table class="tablelist" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th>请求编号</th>
						<th>用户名</th>
						<th>请求类容</th>
						<th>书名</th>
						<th>请求时间</th>
						<th>请求状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						String data = (String) request.getAttribute("requests");
						List<Request> lists = JSON.parseArray(data, Request.class);
					%>
					<c:forEach var="request" items="<%=lists%>">
						<tr>
							<td name="requestId">${request.requestId}</td>
							<td name="userName">${request.userName}</td>
							<td><c:if test="${request.requestCatId==1}">
        		请求借书
       </c:if> <c:if test="${request.requestCatId==2}">
        		请求续借
       </c:if></td>
							<td name="bookName">${request.bookName}</td>
							<td><fmt:formatDate value="${request.requestTime}"
									pattern="yyyy-MM-dd" /></td>
							<td><c:if test="${request.requestStatus==0}">
        		未处理
       </c:if> <c:if test="${request.requestStatus==1}">
        		已批准
       </c:if> <c:if test="${request.requestStatus==2}">
        		已拒绝
       </c:if> <c:if test="${request.requestStatus==3}">
        		挂起
       </c:if></td>
							<td><c:if test="${request.requestStatus==0}">
									<a
										onclick="admit('${request.requestId}','${request.userName}','${request.bookName}')">批准</a>|<a
										onclick="reject('${request.requestId}')">拒绝</a>|
										<a onclick="ignore('${request.requestId}')">挂起</a>
								</c:if> <c:if test="${request.requestStatus==1}">
        	批准|拒绝|挂起
       </c:if> <c:if test="${request.requestStatus==2}">
        	批准|拒绝|挂起
       </c:if> <c:if test="${request.requestStatus==3}">
									<a
										onclick="admit('${request.requestId}','${request.userName}','${request.bookName}')">批准</a>|<a
										onclick="reject('${request.requestId}')">拒绝</a>|挂起
       </c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<!-- /MainForm -->

</body>
</html>