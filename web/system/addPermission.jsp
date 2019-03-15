<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-15
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加权限</title>
    <meta charset="UTF-8">
    <style>
        #wrap{
            text-align: center;
            margin-top: 20px;
        }
        input{
            margin: 10px;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <form action="#" method="post">
            <span>角色：</span>
            <select name="roleName" id="Type">
                <option value="请选择">请选择</option>
                <c:forEach items="${listRole}" var="role">
                    <option value="${role.roleName}">${role.roleName}</option>
                </c:forEach>
            </select><br>
            <span>菜单：</span>
            <select name="menuName" id="status">
                <option value="请选择">请选择</option>
                <c:forEach items="${listMenu}" var="menu">
                    <option value="${menu.menuName}">${menu.menuName}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="保存">
            <input type="reset">
        </form>
    </div>
</body>
</html>
