<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-14
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>报销详情</title>
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
        <h2>报销详情</h2>
        <p>申请人：${reims.reimName}</p>
        <p>报销类型：${reims.reimType}</p>
        <p>摘要：${reims.reimAbstract}</p>
        <p>金额：${reims.reimMoney}</p>
        <p>申请时间：${reims.createTime}</p>
        <p>申请状态：${reims.reimStatus}</p>
    </div>
</body>
</html>
