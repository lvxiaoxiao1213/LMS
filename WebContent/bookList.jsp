<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.alibaba.fastjson.JSON" %>
<%@page import="com.lms.entity.book.Book"%>
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
	/* 删除图书 */
	function del(bookId){
		$.post('${ctx}/BookDelete', { "bookId":bookId }, function (data) { window.location.reload(true) });
	}
</script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>


<!-- MainForm -->
<div id="MainForm">
<div class="form_boxA">
<h2>图书列表</h2>
<table class="tablelist" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th>编号</th>
<th>书名</th>
<th>作者</th>
<th>出版社</th>
<th>类别</th>
<th>状态</th>
<th>备注</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<%
      String data=(String)request.getAttribute("books");
      List<Book> lists=JSON.parseArray(data, Book.class);
%>
<c:forEach var="book" items="<%=lists%>">
<tr>
<td name="bookId">${book.bookId}</td>
<td>${book.bookName}</td>
<td>${book.auth}</td>
<td>${book.publisher}</td>
<td>
      <c:if test="${book.catId==1}">
        		教材教辅
       </c:if>
       <c:if test="${book.catId==2}">
        		少儿
       </c:if>
       <c:if test="${book.catId==3}">
        		生活
       </c:if>
       <c:if test="${book.catId==4}">
        		科技
       </c:if>
       <c:if test="${book.catId==5}">
        		经济
       </c:if>
       <c:if test="${book.catId==6}">
        		人文社科
       </c:if>
       <c:if test="${book.catId==7}">
        		文学艺术
       </c:if>
</td>
<td><c:if test="${book.status==1}">
        		已借出
        	</c:if>
        	<c:if test="${book.status==0}">
        		在库
        	</c:if></td>
<td>${book.remark}</td>
<td> <a onclick="del('${book.bookId}')">删除</a>|
<a href="upload.jsp">上传文件</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</div>
<!-- /MainForm -->

</body>
</html>