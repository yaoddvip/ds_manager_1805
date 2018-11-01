<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/31
  Time: 9:23
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
            //通过 getjson异步加载json数据
            $.getJSON("json/class_1.js", function(json){
                //dom对象如何转换为jquery对象  $()
                $(json).each(function(i,data){
                    console.log(data)
                    $("#class1_select_id").append('<option value="'+data.id+'">'+data.flmch1+'</option>');
                })
            });

        })

        //异步加载class2和品牌
        function load_class2_tm(flbh1) {
            //加载class2
            $.getJSON("json/class_2_"+flbh1+".js", function(json){
                //清空 ：empty()
                $("#class2_select_id").empty();

                //dom对象如何转换为jquery对象  $()
                $(json).each(function(i,data){
                    $("#class2_select_id").append('<option value="'+data.id+'">'+data.flmch2+'</option>');
                })
            });

        }


        //跳转sku增加页面
        function toAddSkuPage(){
            var flbh1 = $("#class1_select_id").val();
            var flbh2 = $("#class2_select_id").val();

            location.href="toAddSkuPage.do?flbh1="+flbh1+"&flbh2="+flbh2;
        }
    </script>
</head>
<body>
    sku
    <hr>

    一级：
    <select id="class1_select_id" onchange="load_class2_tm(this.value)">
        <option>请选择</option>
    </select>

    二级：
    <select id="class2_select_id" >
        <option>请选择</option>
    </select>

    <hr>
    <a href="javascript:toAddSkuPage()">add</a>
</body>
</html>
