<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-16
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改权限</title>
    <style>
        #wrap{
            text-align: center;
            margin-top: 20px;
        }
        input{
            margin: 10px;
        }
    </style>
    <script>
        window.onload = function (ev) {
            var back = document.getElementById("back");
            back.onclick = function (ev1) {
                location.href = "/web/manager/listPrivileges.do?page=1";
            };
        };
    </script>
</head>
<body>
    <div id="wrap">
        <form action="updatePerm.do" method="post">
            <span>角色：</span>
            <select name="roleName" id="Type">
                <option value="请选择">请选择</option>
                <c:forEach items="${listRole}" var="role">
                    <c:choose>
                        <c:when test="${role.id == roleId}">
                            <option value="${role.roleName}" selected>${role.roleName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${role.roleName}">${role.roleName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <span>菜单：</span>
            <select name="menuName" id="status">
                <option value="请选择">请选择</option>
                <c:forEach items="${listMenu}" var="menu">
                    <c:choose>
                        <c:when test="${menu.id == menuId}">
                            <option value="${menu.menuName}" selected>${menu.menuName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${menu.menuName}">${menu.menuName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <input type="submit" value="修改">
            <input type="button" value="返回" id="back">
        </form>
    </div>
</body>
</html>
