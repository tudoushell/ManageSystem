<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-20
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工详细信息</title>
    <meta charset="UTF-8">
    <style>
        #wrap{
            width: 300px;
            margin: 20px auto;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <h2>员工详情</h2>
        <p>员工编号：${empList.empNo}</p>
        <p>员工姓名：${empList.empName}</p>
        <p>性别：${empList.sex}</p>
        <p>所属部门：${empList.empDept}</p>
        <p>入职时间：${empList.entryTime}</p>
    </div>
</body>
</html>
