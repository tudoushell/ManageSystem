<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-20
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>部门详情</title>
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
    <h2>部门详情</h2>
    <p>部门编号：${dept.deptId}</p>
    <p>部门名称：${dept.deptName}</p>
    <p>部门位置：${dept.deptLoc}</p>
    <p>部门负责人	：${dept.deptLeader}</p>
</div>
</body>
</html>
