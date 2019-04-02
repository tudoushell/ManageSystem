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
    <script src="../js/operateAccount.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 &gt;&gt;账户管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="finSearch">
            <form action="listAccount.do?page=1"  method="post" accept-charset="UTF-8">
                <span>账号：</span>
                <input type="text" name="account">
                <span>账号状态：</span>
                <select name="accountStatus" id="Type">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listAccountStatus}" var="accountStatus">
                        <option value="${accountStatus.configPageValue}">${accountStatus.configPageValue}</option>
                    </c:forEach>
                </select>
                <span>角色：</span>
                <select name="roleName" id="status">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listRoleName}" var="listRole">
                        <option value="${listRole.configPageValue}">${listRole.configPageValue}</option>
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
            <c:forEach items="${listAccount}" var="account">
                <tr>
                    <td>${account.userAccount}</td>
                    <td>${account.empName}</td>
                    <td>${account.accountStatus}</td>
                    <td>${account.roleName}</td>
                    <td>
                        <a href="javascript:del('${account.empNo}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updateAccount('${account.empNo}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="listAccount.do?page=1&account=${account}&accountStatus=${accountStatus}&roleName=${roleName}">首页</a>
            <a href="listAccount.do?page=${page - 1}&account=${account}&accountStatus=${accountStatus}&roleName=${roleName}">上一页</a>
            <a href="listAccount.do?page=${page + 1}&account=${account}&accountStatus=${accountStatus}&roleName=${roleName}">下一页</a>
            <a href="listAccount.do?page=${allPage}&account=${account}&accountStatus=${accountStatus}&roleName=${roleName}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>
