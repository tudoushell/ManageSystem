<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-12
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改员工信息</title>
    <link rel="stylesheet" href="../css/addEmp.css">
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="../js/addEmp.js"></script>
</head>
<body>
<div id="wrap">
    <form action="updateEmp.do" method="post" class="emp_info" accept-charset="UTF-8">
        <span>员工编号：</span>
        <input type="text" name="empNo" value="${emp.empNo}" ><br>
        <span>员工姓名：</span>
        <input type="text" name="empName" value="${emp.empName}"><br>
        <div class="left">
            <span>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <select name="sex">
                <option value="${emp.sex}" selected>${emp.sex}</option>
                <c:if test="${emp.sex != '男'}">
                    <option value="男">男</option>
                </c:if>

                <c:if test="${emp.sex != '女'}">
                    <option value="女">女</option>
                </c:if>
            </select><br>
            <span>所属部门：</span>
            <select name="empDept">
                <c:forEach items="${listDept}" var="dept">
                    <c:choose>
                        <c:when test="${dept.deptName == emp.empDept}">
                            <option value="${dept.deptName}" selected>${dept.deptName}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${dept.deptName}">${dept.deptName}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
        </div>
        <span>入职时间：</span>
        <input type="text" name="entryTime" id="time" value="${emp.entryTime}"><br>
        <input type="submit" value="修改">
        <input type="button" value="返回" id="back">
    </form>
</div>
</body>
</html>
