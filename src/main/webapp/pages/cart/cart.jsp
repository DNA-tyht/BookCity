<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/static/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				return confirm("确定删除《" + $(this).parent().parent().find("td:first").text() + "》？");
			});

			$("#clearCart").click(function () {
				return confirm("确定清空购物车？");
			});

			$(".updateCount").change(function () {
				var count = this.value;
				var countTest = /\d/;
				if (countTest.test(count)) {
					var name = $(this).parent().parent().find("td:first").text();
					var id = $(this).attr("bookId");
					if (confirm("确定将《" + name + "》数量修改为" + count + "？")) {
						//发起请求，给服务器保存修改
						location.href = "http://localhost:8080/BookCity/cartServlet?action=updateCount&count=" + count + "&id=" + id;
					} else {
						//defaultValue：value的默认值
						this.value = this.defaultValue;
					}
				} else {
					alert("只能输入数字！");
				}

			});
		});
	</script>
</head>
<body>
<div id="header">
		<img class="logo_img" alt="" src="static/images/DNAlogo.png" height="82px">
		<span class="wel_word">购物车</span>
		<%@ include file="/static/common/login_sucess_menu.jsp"%>
</div>

<div id="main">
	<table>
		<tr>
			<td>商品名称</td>
			<td>数量</td>
			<td>单价</td>
			<td>金额</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${sessionScope.cart.items}" var="entry">
			<tr>
				<td>${entry.value.name}</td>
				<td>
					<input class="updateCount" style="width: 40px"
						   bookId="${entry.value.id}"
						   type="text" value="${entry.value.count}">
				</td>
				<td>${entry.value.price}</td>
				<td>${entry.value.totalPrice}</td>
				<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty sessionScope.cart.items}">
			<tr>
				<td colspan="5">亲，当前购物车为空！快去首页浏览商品吧！</td>
			</tr>
		</c:if>
	</table>
	<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
	</c:if>
</div>
<%@include file="/static/common/footer.jsp"%>
</body>
</html>