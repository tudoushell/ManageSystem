<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-12
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/addEmp.css">
    <script type="text/javascript" src="../laydate/laydate.js"></script>
    <script type="text/javascript" src="../js/addEmp.js"></script>
</head>
<body>
<div id="wrap">
    <form action="addEmp.do" method="post" class="emp_info" accept-charset="UTF-8">
        <span>员工编号：</span>
        <input type="text" name="empNo"><br>
        <span>员工姓名：</span>
        <input type="text" name="empName"><br>
        <div class="left">
            <span>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <select name="sex">
                <option value="男">男</option>
                <option value="女">女</option>
            </select><br>
            <span>所属部门：</span>
            <select name="empDept">
                <option value="总经办">总经办</option>
                <option value="渠道部">渠道部</option>
                <option value="市场营销部">市场营销部</option>
                <option value="教质部">教质部</option>
                <option value="教学部">教学部</option>
                <option value="就业部">就业部</option>
            </select><br>
        </div>
        <span>入职时间：</span>
        <input type="text" name="entryTime" id="time"><br>
        <input type="submit" value="添加">
        <input type="reset" value="重置">
        <input type="button" value="返回" id="back">
    </form>
</div>
</body>
</html>
