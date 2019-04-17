<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-04-17
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假详细信息</title>
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
        <h2>请假详细信息</h2>
        <p>请假编号：${holiday.holidayNo}</p>
        <p>请假姓名：${holiday.holidayUser}</p>
        <p>请假类型：${holiday.holidayType}</p>
        <p>请假事由：${holiday.holidayBz}</p>
        <p>开始时间：${holiday.startTime}</p>
        <p>结束时间：${holiday.endTime}</p>
        <p>申请状态：${holiday.holidayStatus}</p>
    </div>
</body>
</html>
