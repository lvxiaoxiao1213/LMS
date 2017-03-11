<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<script src="js/jquery-1.10.1.min.js"></script>
<script src="js/side.js" type="text/javascript"></script>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body>
<header>
<!-- Header -->
<div id="Header">
<!-- Head -->
<div id="Head">
<h1 title="图书馆管理系统">图书馆管理系统</h1>
<script language="javascript">
function showmenu(id){id.style.visibility = "visible";}
function hidmenu(){UserList.style.visibility = "hidden";}
document.onclick = hidmenu;
</script>
<div style="width:100px;float:left;padding:17px 10px 16px 1200px;no-repeat 1.5em 1em;position:relative;z-index:999;">
未处理请求<a href="${ctx}/RequestList" target="rightFrame" >(${count})</a></div>
<div class="user"><a href="javascript:showmenu(UserList)">admin</a>
<div id="UserList"><a href="">修改</a>
<a href="${ctx}/Logout" target="_top">注销</a></div>
</div>
</div>
<!-- /Head -->
<nav>
<ul id="Navi">
<li><a href=""><img src="images/common/navi01.png" width="30" height="36" alt="主页管理"><span></span></a></li>
<li><a href=""><img src="images/common/navi02.png" width="36" height="36" alt="系统管理"><span></span></a></li>
<li><a href=""><img src="images/common/navi03.png" width="26" height="36" alt="合同信息"><span></span></a></li>
<li><a href=""><img src="images/common/navi04.png" width="34" height="36" alt="基础数据"><span></span></a></li>
<li><a href=""><img src="images/common/navi05.png" width="24" height="36" alt="预算管理"><span></span></a></li>
<li><a href=""><img src="images/common/navi06.png" width="36" height="36" alt="项目管理"><span></span></a></li>
<li><a href=""><img src="images/common/navi07.png" width="34" height="36" alt="资金支付-发票"><span></span></a></li>
<li><a href=""><img src="images/common/navi08.png" width="34" height="36" alt="产品管理信息"><span></span></a></li>
</ul>
</nav>
</div>
</div>
<!-- /Header -->
</header>
</body>
</html>