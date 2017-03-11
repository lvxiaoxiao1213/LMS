<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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


<!-- MainForm -->

<script type="text/javascript">
$(function(){
$(".select").each(function(){
var s=$(this);
var z=parseInt(s.css("z-index"));
var dt=$(this).children("dt");
var dd=$(this).children("dd");
var _show=function(){dd.slideDown(200);dt.addClass("cur");s.css("z-index",z+1);};
var _hide=function(){dd.slideUp(200);dt.removeClass("cur");s.css("z-index",z);};
dt.click(function(){dd.is(":hidden")?_show():_hide();});
dd.find("a").click(function(){dt.html($(this).html());_hide();});
$("body").click(function(i){ !$(i.target).parents(".select").first().is(s) ? _hide():"";});})})
</script>

<form action="BookAdd " method="post">
<div class="form_boxC">
<table cellpadding="0" cellspacing="0">
<tr>
<th>书名</th>
<td><div class="txtbox floatL"><input id="bookname" name="bookname" type="text" size="40"></div></td>
</tr>
<tr>
<th>作者</th>
<td><div class="txtbox floatL"><input id="auth" name="auth" name="" type="text" size="40"/></div></td>
</tr>
<tr>
<th>出版社</th>
<td><div class="txtbox floatL"><input id="publisher" name="publisher" type="text" size="40"/></div></td>
</tr>
<tr>
<tr>
<th>类别</th>
<td>
<select id="category"  name="category">
<option value="1" >教材教辅</option>
<option value="2">少儿</option>
<option value="3">生活</option>
<option value="4">科技</option>
<option value="5">经济</option>
<option value="6">人文社科</option>
<option value="7">文学艺术</option>
</select></td>
</tr>
<tr>
<th>备注</th>
<td><div class="txtbox floatL"><input id="remark" name="remark" type="text" size="40"/></div></td>
</tr>
<tr>
<th></th>
<td><div class="txtbox floatL"><input value="添加" type="submit" action=""></input></div></td>
</tr>

</table>

</div>
</form>

</body>
</html>