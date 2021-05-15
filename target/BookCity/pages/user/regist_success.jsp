<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功页面</title>
	<%@include file="/static/common/head.jsp"%>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/images/DNAlogo.png" height="82px">
				<span class="wel_word"></span>
				<%@ include file="/static/common/login_sucess_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.jsp">转到主页</a></h1>
	
		</div>
		<%@include file="/static/common/footer.jsp"%>
</body>
</html>