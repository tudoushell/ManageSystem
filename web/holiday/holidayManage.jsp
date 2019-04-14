<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-04-14
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假管理</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/finacial.css">
    <script src="../js/operateHoliday.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 &gt;&gt;请假管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="finSearch">
            <form action="listHoliday.do?page=1"  method="post" accept-charset="UTF-8">
                <span>申请人：</span>
                <input type="text" name="holidayUser">
                <span>请假类型：</span>
                <select name="holidayType" id="Type">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listHolidayType}" var="holidayType">
                        <option value="${holidayType.configPageValue}">${holidayType.configPageValue}</option>
                    </c:forEach>
                </select>
                <span>申请状态：</span>
                <select name="holidayStatus" id="status">
                    <option value="请选择">请选择</option>
                    <c:forEach items="${listHolidayStatus}" var="holidayStatus">
                        <option value="${holidayStatus.configPageValue}">${holidayStatus.configPageValue}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询" id="search">
            </form>
        </div>
        <p><a href="/web/system/addAccount.jsp"><img id="add_table" src="../img/add.png" alt="add">添加请假</a></p>
        <table>
            <tbody>
            <tr>
                <th>请假编号</th>
                <th>申请人</th>
                <th>请假类型</th>
                <th>请假事由</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>申请状态</th>
                <th>提交时间</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${listHoliday}" var="holiday">
                <tr>
                    <td>${holiday.holidayNo}</td>
                    <td>${holiday.holidayUser}</td>
                    <td>${holiday.holidayType}</td>
                    <td>${holiday.holidayBz}</td>
                    <td>${holiday.startTime}</td>
                    <td>${holiday.endTime}</td>
                    <td>${holiday.holidayStatus}</td>
                    <td>${holiday.createTime}</td>
                    <td>
                        <a href="javascript:del('${holiday.holidayNo}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updateAccount('${holiday.holidayNo}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                        <a href="javascript:detailDept('${holiday.holidayNo}');">
                            <img src="../img/detail.png" alt="#">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="listHoliday.do?page=1&holidayUser=${holidayUser}&holidayType=${holidayType}&holidayStatus=${holidayStatus}">首页</a>
            <a href="listHoliday.do?page=${page - 1}&holidayUser=${holidayUser}&holidayType=${holidayType}&holidayStatus=${holidayStatus}">上一页</a>
            <a href="listHoliday.do?page=${page + 1}&holidayUser=${holidayUser}&holidayType=${holidayType}&holidayStatus=${holidayStatus}">下一页</a>
            <a href="listHoliday.do?page=${allPage}&holidayUser=${holidayUser}&holidayType=${holidayType}&holidayStatus=${holidayStatus}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>

