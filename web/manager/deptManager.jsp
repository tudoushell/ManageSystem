<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-11
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
</head>
<body>

<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 >>部门管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <p><a href="addDept.jsp"><img id="add_table" src="../img/add.png" alt="add">添加部门 </a></p>
        <table>
            <tbody>
                <tr>
                    <th>部门编号</th>
                    <th>部门名称</th>
                    <th>部门位置</th>
                    <th>部门负责人</th>
                    <th>操作列表</th>
                </tr>
                <c:forEach items="${deptLists}" var="listDept">
                    <tr>
                        <td>${listDept.deptId}</td>
                        <td>${listDept.deptName}</td>
                        <td>${listDept.deptLoc}</td>
                        <td>${listDept.deptLeader}</td>
                        <td>
                            <a href="javascript:del('${listDept.deptId}','${listDept.deptName}');">
                                <img class="del_table" src="../img/bullet_delete.png" alt="#">
                            </a>
                            <a href="javascript:changeDept('${listDept.deptId}');">
                                <img src="../img/calendar_edit.png" alt="#">
                            </a>
                            <a href="javascript:detailDept('${listDept.deptId}');">
                                <img src="../img/detail.png" alt="#">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="list.do?page=1">首页</a>
            <a href="list.do?page=${page - 1}">上一页</a>
            <a href="list.do?page=${page + 1}">下一页</a>
            <a href="list.do?page=${sum}">尾页</a>
            <span>第${page}页</span>
            <span>共${sum}页</span>
        </div>
    </div>
</div>

</body>
</html>
