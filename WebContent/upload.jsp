<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<title>Insert title here</title>

<style type="text/css">

  * {
				margin: 0;
				padding: 0;
				font-family: "微软雅黑";
				font-size:20px;
				font-weight:light;
			}
			



</style>



</head>
<body>
	<form action="${ctx}/FileUpload" enctype="multipart/form-data"
		method="post">
		<table cellpadding="0" cellspacing="0">
		<tr><td>
		<br/>
		上传文件:<input type="file" name="file1"></input><br/></td></tr>
	    <tr><td >
	    </br>
		<div  class="txtbox floatL"><input type="submit" value="提交"></input></div></td></tr>
		</table>
	</form>
</body>
</html>