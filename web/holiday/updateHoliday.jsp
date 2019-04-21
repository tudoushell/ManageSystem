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
    <title>修改请假信息</title>
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
        <form action="updateHoliday.do" method="post">
            <span>请假类型：</span>
            <select name="holidayType">
                <c:forEach items="${listHolidayType}" var="holidayType" varStatus="status">
                    <c:choose>
                        <c:when test="${holidayInfo.holidayType == holidayType.configPageValue}">
                            <option value="${status.index + 1}" selected>${holidayType.configPageValue}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${status.index + 1}">${holidayType.configPageValue}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <span>请假事由：</span>
            <textarea name="holidayBz">${holidayInfo.holidayBz}</textarea><br>
            <span>开始时间：</span>
            <input type="text" name="startTime" id="startTime" value="${holidayInfo.startTime}"><br>
            <span>结束时间：</span>
            <input type="text" name="endTime" id="endTime" value="${holidayInfo.endTime}"><br>
            <input type="submit" name="holidayStatus" value="草稿">
            <input type="submit" name="holidayStatus" value="提交">
            <input type="reset">
        </form>
    </div>
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script>
        lay('#version').html('-v'+ laydate.v);
        //执行一个laydate实例
        laydate.render({
            elem: '#startTime',//指定元素
            trigger: 'click'
        });
        laydate.render({
            elem: '#endTime',//指定元素
            trigger: 'click'
        });
    </script>
</body>
</html>
