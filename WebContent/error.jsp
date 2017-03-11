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
                <style>
                #landing{
				
				
				padding: 15px 0;
				color: #545454;
			}
			
			#landing-content {
				clear: both;
			}
                #photo {
				border-radius: 80px;
				height: 180px;
				width: 180px;
				margin: 0 auto;
				overflow: hidden;
				clear: both;
			
				
			}
			
			#photo>img:hover {
				-webkit-transform: rotateZ(360deg);
				-moz-transform: rotateZ(360deg);
				-o-transform: rotateZ(360deg);
				-ms-transform: rotateZ(360deg);
				transform: rotateZ(360deg);
			}
			
			#photo>img {
				height: 180px;
				width: 180px;
				-webkit-background-size: 220px 220px;
				border-radius: 60px;
				-webkit-transition: -webkit-transform 1s linear;
				-moz-transition: -moz-transform 1s linear;
				-o-transition: -o-transform 1s linear;
				-ms-transition: -ms-transform 1s linear;
			}
			
          </style>

<body>
	  <div style="padding-bottom:35px;background-color:#1e628f"> 
	    <div id="landing"></div>
		<div id="landing-content">
		<div id="photo"><img src="images/photo1.jpg" /></div>
        <h2 style="padding-left:480px;"><a href="register.jsp" >注册失败，请重新填写</a></h2>
		</div>
	  </div>
		
          
	</body>

</html>