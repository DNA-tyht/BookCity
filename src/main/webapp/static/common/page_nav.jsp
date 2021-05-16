<%--
  User: 脱氧核糖
  Date: 2021/5/16
  Time: 13:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $("#searchPageBtn").click(function () {
            var pageNo = $("#pn_input").val();
            //location：地址栏对象
            //可以获取浏览器地址栏中的地址
            //href属性可读可写
            if (pageNo < 1) {
                pageNo = 1;
            } else if (pageNo > ${requestScope.page.pageTotal}) {
                pageNo = ${requestScope.page.pageTotal};
            }
            location.href = "http://localhost:8080/BookCity/${requestScope.page.url}&pageNo=" + pageNo;
        });
    });
</script>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">${requestScope.page.pageNo - 1}</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <%--    &lt;%&ndash;  页码输出  &ndash;%&gt;--%>
    <%--    <c:choose>--%>
    <%--        <:c:when test="${requestScope.page.pageTotal <= 5}">--%>
    <%--            <c:set var="begin" value="1" />--%>
    <%--            <c:set var="end" value="${requestScope.page.pageTotal}" />--%>
    <%--        </:c:when>--%>

    <%--        <:c:when test="${requestScope.page.pageTotal > 5}">--%>
    <%--            <c:choose>--%>
    <%--                <c:when test="${requestScope.page.pageNo <= 3}">--%>
    <%--                    <c:set var="begin" value="1" />--%>
    <%--                    <c:set var="end" value="5" />--%>
    <%--                </c:when>--%>
    <%--                <c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal - 3}">--%>
    <%--                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}" />--%>
    <%--                    <c:set var="end" value="${requestScope.page.pageTotal}" />--%>
    <%--                </c:when>--%>
    <%--                <c:otherwise>--%>
    <%--                    <c:set var="begin" value="${requestScope.page.pageTotal - 2}" />--%>
    <%--                    <c:set var="end" value="${requestScope.page.pageTotal + 2}" />--%>
    <%--                </c:otherwise>--%>
    <%--            </c:choose>--%>
    <%--        </:c:when>--%>
    <%--    </c:choose>--%>
    <%--    <c:forEach begin="${begin}" end="${end}" var="i">--%>
    <%--        <c:if test="${i == requestScope.page.pageNo}">--%>
    <%--            【${i}】--%>
    <%--        </c:if>--%>
    <%--        <c:if test="${i != requestScope.page.pageNo}">--%>
    <%--            <a href="http://localhost:8080/BookCity/${requestScope.page.url}&pageNo=${i}">${i}</a>--%>
    <%--        </c:if>--%>
    <%--    </c:forEach>--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">${requestScope.page.pageNo + 1}</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页
    到第<input value="" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
</div>
