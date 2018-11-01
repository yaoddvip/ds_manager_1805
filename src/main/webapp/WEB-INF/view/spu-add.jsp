<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/29
  Time: 11:31
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
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script>
        function f() {
        }
    </script>
</head>
<body>
    spu-add
    <hr>
    flbh1:${spu.flbh1}--
    flbh2:${spu.flbh2}--
    ppId:${spu.ppId}
    <hr>
    <form action="addSpu.do" method="post" enctype="multipart/form-data">

        <input type="hidden" name="flbh1" value="${spu.flbh1}">
        <input type="hidden" name="flbh2" value="${spu.flbh2}">
        <input type="hidden" name="ppId" value="${spu.ppId}">
        <br>
        商品名称：<input type="text" name="shpMch">
        <br>
        商品描述：<textarea name="shpMsh"></textarea>
        <br>
        图片：<input type="file" name="imgs"/>
            <input type="file" name="imgs"/>
            <input type="file" name="imgs"/>
        <br>
        <input type="submit">
    </form>
</body>
</html>
