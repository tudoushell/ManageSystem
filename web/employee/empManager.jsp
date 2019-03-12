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
    <script src="../js/operateEmp.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 >>员工管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="empSearch">
            <form action="empList.do?page=1"  method="post" accept-charset="UTF-8">
                <span>姓名：</span>
                <input type="text"name="empName" id="empNames">
                <span>部门：</span>
                <select name="empDept" id="emDepts">
                    <option value="总经办">总经办</option>
                    <option value="渠道部">渠道部</option>
                    <option value="市场营销部">市场营销部</option>
                    <option value="教质部">教质部</option>
                    <option value="教学部">教学部</option>
                    <option value="就业部">就业部</option>
                </select>
                <input type="submit" value="查询" id="search">
            </form>
        </div>
        <p><a href="/web/employee/addEmp.jsp"><img id="add_table" src="../img/add.png" alt="add">添加员工</a></p>
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
            <c:forEach items="${listEmp}" var="emp">
                <tr>
                    <td>${emp.empNo}</td>
                    <td>${emp.empName}</td>
                    <td>${emp.sex}</td>
                    <td>${emp.empDept}</td>
                    <td>${emp.entryTime}</td>
                    <td>
                        <a href="javascript:del('${emp.empNo}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updateDept('${emp.empNo}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                        <img src="../img/detail.png" alt="#">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="empList.do?page=1&empName=${empNames}&empDept=${empDepts}">首页</a>
            <a href="empList.do?page=${page - 1}&empName=${empNames}&empDept=${empDepts}">上一页</a>
            <a href="empList.do?page=${page + 1}&empName=${empNames}&empDept=${empDepts}">下一页</a>
            <a href="empList.do?page=${allPage}&empName=${empNames}&empDept=${empDepts}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>
