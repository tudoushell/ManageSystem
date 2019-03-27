<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-26
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改角色权限</title>
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
        <form action="updateRole.do" method="POST">
            <span>角色名称：</span>
            <input type="text" name="roleName" value="${role.roleName}"><br>
            <input type="submit" value="修改">
            <input type="button" value="返回" id="back">
        </form>
    </div>
</body>
</html>
