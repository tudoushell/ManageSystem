<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-28
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
    <meta charset="UTF-8">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #wrap{
            width: 500px;
            margin: 30px auto;
            text-align: center;
        }
        input{
            margin-top: 10px;
        }
    </style>
    <script>
        window.onload = function (ev) {
            var back = document.getElementById("back");
            back.onclick = function (ev1) {
                window.location.href = "/web/manager/listRole.do";
            };
        };
    </script>
</head>
<body>
<div id="wrap">
    <form action="saveRole.do" method="POST">
        <span>角色名称：</span>
        <input type="text" name="roleName"><br>
        <input type="submit" value="添加">
        <input type="button" value="返回" id="back">
    </form>
</div>
</body>
</html>
