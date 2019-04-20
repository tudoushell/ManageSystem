<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-04-20
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加请假信息</title>
    <style>
        #wrap{
            width: 300px;
            margin: 20px auto;
        }
        textarea{
            resize: none;
        }
    </style>
    <meta charset="UTF-8">

</head>
<body>
    <div id="wrap">
        <form action="saveHoliday.do" method="post">
            <span>请假类型：</span>
            <select name="holidayType">
                <c:forEach items="${listHolidayType}" var="holidayType" varStatus="status">
                    <option value="${status.index + 1}">${holidayType.configPageValue}</option>
                </c:forEach>
            </select><br>
            <span>请假事由：</span>
            <textarea name="holidayBz"></textarea><br>
            <span>开始时间：</span>
            <input type="text" name="startTime" id="startTime"><br>
            <span>结束时间：</span>
            <input type="text" name="endTime" id="endTime"><br>
            <input type="submit" name="holidayStatus" value="草稿">
            <input type="submit" name="holidayStatus" value="提交">
            <input type="reset">
        </form>
    </div>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="../js/addHoliday.js"></script>
</body>
</html>
