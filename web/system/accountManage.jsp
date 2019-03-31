<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-31
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>帐户管理</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/finacial.css">
    <script src="../js/operatePerm.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 &gt;&gt;账户管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="finSearch">
            <form action="listPrivileges.do?page=1"  method="post" accept-charset="UTF-8">
                <span>账号：</span>
                <input type="text" name="account">
                <span>账号状态：</span>
                <select name="roleName" id="Type">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listRole}" var="role">
                        <option value="${role.roleName}">${role.roleName}</option>
                    </c:forEach>
                </select>
                <span>角色：</span>
                <select name="menuName" id="status">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listMenu}" var="menu">
                        <option value="${menu.menuName}">${menu.menuName}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询" id="search">
            </form>
        </div>
        <p><a href="/web/system/addPermission.jsp"><img id="add_table" src="../img/add.png" alt="add">添加权限</a></p>
        <table>
            <tbody>
            <tr>
                <th>账号</th>
                <th>员工姓名</th>
                <th>状态</th>
                <th>角色</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${listPrivileges}" var="privileges">
                <tr>
                    <td>${privileges.roleId}</td>
                    <td>${privileges.roleName}</td>
                    <td>${privileges.menuId}</td>
                    <td>${privileges.menuName}</td>
                    <td>
                        <a href="javascript:del('${privileges.id}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updatePerm('${privileges.roleId}','${privileges.menuId}','${privileges.id}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="listPrivileges.do?page=1&roleName=${roleName}&menuName=${menuName}">首页</a>
            <a href="listPrivileges.do?page=${page - 1}&roleName=${roleName}&menuName=${menuName}">上一页</a>
            <a href="listPrivileges.do?page=${page + 1}&roleName=${roleName}&menuName=${menuName}">下一页</a>
            <a href="listPrivileges.do?page=${allPage}&roleName=${roleName}&menuName=${menuName}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>
