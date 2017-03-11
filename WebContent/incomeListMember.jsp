<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON" %>
<%@page import="com.lms.entity.Income"%>
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


<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<script type="text/javascript">
	/* 付款 */
	function pay(incomeId){
		$.post('${ctx}/IncomeStatus', { "incomeId":incomeId }, function (data) { window.location.reload(true) });
	}
</script>
</head>

<body>
<%
      String data=(String)request.getAttribute("incomes");
	  String data2=(String)request.getAttribute("user");
      List<Income> lists=JSON.parseArray(data, Income.class);
%>

<!-- MainForm -->
<div id="MainForm">
<div class="form_boxA">
<h2>支出列表</h2>
<table class="tablelist" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th>支出编号</th>
<th>支出类型</th>
<th>支出金额</th>
<th>付款状态</th>
<th>操作</th>
</tr>
</thead>
<tbody var="user" items="<%=data2%>">

<c:forEach var="income" items="<%=lists%>">
<c:if test="${income.userName==user}">
<tr>
<td>${income.incomeId}</td>
<td><c:if test="${income.incomeCat==1}">
        		VIP会员费
       </c:if>
       <c:if test="${income.incomeCat==2}">
        		罚款
       </c:if>
       <c:if test="${income.incomeCat==3}">
        		快递费
       </c:if></td>
<td>${income.money}</td>
<td><c:if test="${income.incomeStatus==0}">
        		未付款
       </c:if>
       <c:if test="${income.incomeStatus==1}">
       			已付款
       </c:if></td></td>
<td><c:if test="${income.incomeStatus==0}">
        		 <a onclick="pay('${income.incomeId}')">付款</a>
       </c:if>
       <c:if test="${income.incomeStatus==1}">
       			          付款
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