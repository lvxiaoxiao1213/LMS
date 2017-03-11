<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="js/jquery-2.2.4.min.js"></script>
		<script>
			$(document).ready(function() {
				
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
			});
		</script>
		<script text="text/javascript">
			function checkPwd(){
				var p1=document.getElementById("password").value;
				var p2=document.getElementById("passwordconfirm").value;
				if(p1!=p2){
					document.getElementById("msg").innerHTML="两次密码不一致";
					return false;
				}else 
					document.getElementById("msg").innerHTML="";
					return true;
			}
		</script>
		<style>
            #landing{  
				
				text-align: center;
				width: 170px;
				padding: 15px 0;
				color: #545454;
			}
			
			#landing-content {
				clear: both;
			}
            .inp {
				height: 30px;
				margin: 0 auto;
				margin-bottom: 30px;
				width: 200px;
			}
			.inp>input {
				text-align: center;
				height: 30px;
				width: 200px;
				margin: 0 auto;
				transition: all 0.3s ease-in-out;
			}
			
			.login {
				border: 1px solid #A6A6A6;
				color: #a6a6a6;
				height: 30px;
				width: 202px;
				text-align: center;
				font-size: 13.333333px;
				margin-left: 95px;
				line-height: 30px;
				margin-top: 30px;
				transition: all 0.3s ease-in-out;
			}
			
			.login:hover {
				background: #A6A6A6;
				color: #fff;
			}
			
			.form {
				border:1px soild #A6A6A6;
				position: absolute;
				top: 50%;
				left: 50%;
				margin-left: -185px;
				margin-top: -210px;
				height: 570px;
				width: 390px;
				font-size: 18px;
				-webkit-box-shadow: 0px 0px 10px #A6A6A6;
				background: #fff;
			}
            .fix {
				clear: both;
			}
            * {
				margin: 0;
				padding: 0;
				font-family: "微软雅黑";
			}
                        body {
				background: #F7F7F7;
			}
			
              </style>
	</head>

	<body>
	   <div  style="background-image:url(images/4.jpg);width:1920px;
                             height:894px;">
	   <a href="index.jsp">图书馆管理系统</a>
		<div class="form" style="opacity:0.88">
                      
			<div id="landing">会员注册</div>
                        <div class="fix"></div>
			<form name="form" method="post" action="Register">
			<div id="landing-content">
				<div class="inp"><input id="name" name="name"  type="text" placeholder="姓名" /></div>
                <div class="inp"><input id="tell" name="tell" type="text" placeholder="电话号码" /></div>
				<div class="inp"><input id="idcard" name="idcard" type="text" placeholder="身份证号码" /></div>
				<div class="inp"><input id="address" name="address" type="text" placeholder="地址" /></div>
                <div class="inp"><input id="email" name="email" type="text" placeholder="邮箱" /></div>
                <div class="inp"><input id="password" name="password" type="password" placeholder="密码" /></div>
                <div class="inp"><input id="passwordconfirm" name="passwordconfirm" onchange="checkPwd()" type="password" placeholder="确认密码" /></div>
                <div style="color:red;padding-left:100px;" id="msg"></div>
				<div class="login"><input type="submit" value="提交"  style="background-color:white;color:#a6a6a6;height: 30px;
				width: 202px;" ></input></div>
				
			</div>
			
		</div>

    </div>
	</body>

</html>