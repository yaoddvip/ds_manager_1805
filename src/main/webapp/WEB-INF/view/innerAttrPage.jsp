<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/30
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>标题</title>
    <script>
        function f() {
        }
    </script>
</head>
<body>
    内嵌页
    <table>
        <c:forEach items="${list}" var="attr">
            <tr>
                <td>${attr.shxmMch}：</td>
                    <c:forEach items="${attr.valueList}" var="val">
                        <td>${val.shxzh}${val.shxzhMch}</td>
                    </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
