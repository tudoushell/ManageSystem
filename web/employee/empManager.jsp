<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-11
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/emp.css">
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 >>员工管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="empSearch">
            <form action="#"  method="post" accept-charset="UTF-8">
                <span>姓名：</span>
                <input type="text"name="emp_name">
                <span>部门：</span>
                <select name="dept">
                    <option value="总经办">总经办</option>
                    <option value="渠道部">渠道部</option>
                    <option value="市场营销部">市场营销部</option>
                    <option value="教质部">教质部</option>
                    <option value="教学部">教学部</option>
                    <option value="就业部">就业部</option>
                </select>
                <input type="submit" value="查询">
            </form>
        </div>
        <p><a href="addDept.jsp"><img id="add_table" src="../img/add.png" alt="add">添加员工</a></p>
        <table>
            <tbody>
            <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>姓别</th>
                <th>所属部门</th>
                <th>入职时间</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${deptLists}" var="listDept">
                <tr>
                    <td>${listDept.deptId}</td>
                    <td>${listDept.deptName}</td>
                    <td>${listDept.deptLoc}</td>
                    <td>${listDept.deptLeader}</td>
                    <td></td>
                    <td>
                        <a href="javascript:del('${listDept.deptId}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:changeDept('${listDept.deptId}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                        <img src="../img/detail.png" alt="#">
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
