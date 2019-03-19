
<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-19
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页&gt;&gt;角色管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <p><a href="addRole.jsp"><img id="add_table" src="../img/add.png" alt="add">添加角色</a></p>
        <table>
            <tbody>
            <tr>
                <th>角色ID</th>
                <th>角色名称</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${listRole}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.roleName}</td>
                    <td>
                        <a href="javascript:del('${role.id}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:changeDept('${role.id}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                        <img src="../img/detail.png" alt="#">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
