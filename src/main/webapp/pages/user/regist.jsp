<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
	<%@include file="/static/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//验证码刷新
			$("#code_img").click(function () {
				//src：验证码img属性的的图片路径
				this.src = "${basePath}kaptcha.jpg?time=" + new Date();
			});

			//注册
			$("#sub_btn").click(function () {
				//获取输入框内容
				var usernameText = $("#username").val();
				//正则表达式
				var usernamePatt = /^\w{5,12}$/;
				//test方法验证
				if (!usernamePatt.test(usernameText)) {
					//提示用户结果
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}

				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if (!passwordPatt.test(passwordText)) {
					$("span.errorMsg").text("密码不合法！");
					return false;
				}

				var repwdText = $("#repwd").val();
				if (repwdText != passwordText) {
					$("span.errorMsg").text("确认密码不正确！");
					return false;
				}

				var emailText = $("#email").val();
				var emailPatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailPatt.test(emailText)) {
					$("span.errorMsg").text("邮箱不合法！");
					return false;
				}

				var codeText = $("#code").val();
				//去掉验证码前后空格
				codeText = $.trim(codeText);
				if (codeText == null || codeText == "") {
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}
				return true;
			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/images/DNAlogo.png" height="82px">
	</div>

		<div class="login_banner">

			<div id="l_content">
				<span class="login_word">欢迎注册</span>
			</div>

			<div id="content">
				<div class="login_form">
					<div class="login_box">
						<div class="tit">
							<h1>注册会员</h1>
							<span class="errorMsg">
								${ requestScope.msg }
							</span>
						</div>
						<div class="form">
							<form action="userServlet" method="post">
								<input type="hidden" name="action" value="regist">
								<label>用户名称：</label>
								<input class="itxt" type="text" placeholder="请输入用户名"
									   value="${ requestScope.username }"
									   autocomplete="off" tabindex="1" name="username" id="username" />
								<br />
								<br />
								<label>用户密码：</label>
								<input class="itxt" type="password" placeholder="请输入密码"
									   autocomplete="off" tabindex="1" name="password" id="password" />
								<br />
								<br />
								<label>确认密码：</label>
								<input class="itxt" type="password" placeholder="确认密码"
									   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
								<br />
								<br />
								<label>电子邮件：</label>
								<input class="itxt" type="text" placeholder="请输入邮箱地址"
									   value="${ requestScope.email }"
									   autocomplete="off" tabindex="1" name="email" id="email" />
								<br />
								<br />
								<label>验证码：</label>
								<input class="itxt" type="text" style="width: 100px;" name = "code" id="code"/>
								<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 50px" width="110px" height="40px">
								<br />
								<br />
								<input type="submit" value="注册" id="sub_btn" />
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	<%@include file="/static/common/footer.jsp"%>
</body>
</html>