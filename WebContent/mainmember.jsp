<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>会员界面</title>
<frameset rows="15.5%,85.5%" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="headmember.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame"/>
	<frameset cols="13.5%,86.5%" frameborder="no" border="0" framespacing="0">
		<frame src="leftNavmember.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame"/>
		<frame src="contentmember.jsp" name="rightFrame" id="rightFrame" title="rightFrame"/>
	</frameset>
</frameset>
</html>