<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-14
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改报销</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/addReim.css">
    <script src="../js/addReim.js"></script>
</head>
<body>
<div id="wrap">
    <form action="updateReimburse.do" method="post">
        <span>&nbsp;&nbsp;报销号：</span>
        <input name="reimNo" value="${reim.reimNo}" disabled><br>
        <div id="type">
            <span>报销类型：</span>
            <select name="reimType">
                <option>请选择</option>
                <option value="差旅费" selected>差旅费</option>
                <option value="招待费">招待费</option>
                <option value="办公费">办公费</option>
            </select><br>
        </div>
        <span>摘要：</span>
        <textarea name="reimAbstract">${reim.reimAbstract}</textarea><br>
        <span>金额：</span>
        <input type="text" name="cost" value="${reim.reimMoney}"><br>
        <input type="submit" name="reimStatus" value="草稿">
        <input type="submit" name="reimStatus" value="提交">
        <input type="reset">
        <input type="button" value="返回" id="back">
    </form>
</div>
</body>
</html>
