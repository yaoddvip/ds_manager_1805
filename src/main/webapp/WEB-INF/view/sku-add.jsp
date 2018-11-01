<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/31
  Time: 9:28
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
        $(function () {
            var flbh1 = "${flbh1}";
            $.getJSON("json/tm_class_1_" + flbh1 + ".js", function (json) {
                $("#tm_select_id").empty();
                $(json).each(function (i, data) {
                    $("#tm_select_id").append('<option value="' + data.id + '">' + data.ppmch + '</option>');
                })
            });
        })


        function selectSpu(tmId) {
            var flbh2 = "${flbh2}";
            $.post("selectSpu.do", {"flbh2": flbh2, "ppId": tmId}, function (json) {
                console.log(json);
                $("#spu_select_id").empty();
                $(json).each(function (i, spu) {
                    $("#spu_select_id").append('<option value="' + spu.id + '">' + spu.shpMch + '</option>');
                })

            })
        }
    </script>
</head>
<body>
    <form action="saveSku.do" method="post">
        <input type="hidden" value="${flbh1}" name="flbh1">
        <input type="hidden" value="${flbh2}" name="flbh2">

        品牌：<select id="tm_select_id" onchange="selectSpu(this.value)">
                <option>请选择</option>
            </select>

        商品：<select id="spu_select_id" name="shpId">
                  <option>请选择</option>
            </select>
    <hr>
    <table>
        <%--
            varStatus="i"可以定义for循环的i
            ${i.index}可以获取到当前的下标
        --%>
        <c:forEach items="${attrList}" var="attr" varStatus="i">
            <tr>
                <td>
                        <input type="hidden" name="attrValues[${i.index}].shxmId" value="${attr.id}">
                        ${attr.shxmMch}：
                </td>
                <c:forEach items="${attr.valueList}" var="val">
                    <td>
                        <input type="radio" name="attrValues[${i.index}].shxzhId" value="${val.id}">
                        ${val.shxzh}${val.shxzhMch}
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

    sku名称:<input type="text" name="skuMch">
        <br>
    价格:<input type="text" name="jg">
        <br>
    库存:<input type="text" name="kc">
        <br>
    库存地址:<input type="text" name="kcdz">
        <br>
        <input type="submit">
</form>
</body>
</html>
