<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.lms.entity.Issuance"%>
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
<script type="text/javascript">
	/* 续借请求 */
	function renewBook(bookName, userName) {
		$.post('${ctx}/RequestAddRenew', {
			"bookName" : bookName,
			"userName" : userName
		}, function(data) {
			window.location.reload(true)
		});
	}
</script>
</head>

<body>
	<%
		String data = (String) request.getAttribute("issuances");
		String data2 = (String) request.getAttribute("user");
		List<Issuance> lists = JSON.parseArray(data, Issuance.class);
	%>

	<!-- MainForm -->
	<div id="MainForm">
		<div class="form_boxA">
			<h2>借书列表</h2>
			<table class="tablelist" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th>借书编号</th>
						<th>用户名</th>
						<th>书名</th>
						<th>借出时间</th>
						<th>归还时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody var="user" items="<%=data2%>">

					<c:forEach var="issuance" items="<%=lists%>">
						<c:if test="${issuance.userName==user}">
							<tr>
								<td>${issuance.issuanceId}</td>
								<td>${issuance.userName}</td>
								<td>${issuance.bookName}</td>
								<td><fmt:formatDate value="${issuance.issuanceDate}"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${issuance.returnDate}"
										pattern="yyyy-MM-dd" /></td>
								
								<td><c:if test="${issuance.issuanStatus==0}">
										<a
											onclick="renewBook('${issuance.bookName}','${issuance.userName}')">续借</a>
									</c:if> <c:if test="${issuance.issuanStatus==1}">
        		续借
       </c:if></td>
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