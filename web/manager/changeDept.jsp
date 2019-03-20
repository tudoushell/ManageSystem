<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-05
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门信息</title>
    <style>
        #wrap{
            text-align: center;
            width: 500px;
            margin: 0 auto;

        }
        form > input{
            /*display: block;*/
            margin-bottom: 10px;
        }
    </style>
    <script>
        window.onload = function () {
            var returns = document.getElementById("returns");
            returns.onclick = function (ev1) {
                window.location.href = "list.do?page=1";
            };
        };
    </script>
</head>
<body>
    <div id="wrap">
        <form action="change.do" method="post" accept-charset="UTF-8">
            <label for="deptid">部门编号:</label>
            <input type="text" id="deptid" name="deptId" value="${dt.deptId}"/><br>
            <label for="deptname">部门名称:</label>
            <input type="text" id="deptname" name="deptName" value="${dt.deptName}"/><br>
            <label for="deptloc">部门位置:</label>
            <input type="text" id="deptloc" name="deptLoc" value="${dt.deptLoc}"/><br>
            <label for="deptleader">部门负责人:</label>
            <input type="text" id="deptleader" name="deptLeader" value="${dt.deptLeader}"/><br>
            <input type="submit" value="修改"/>
            <input type="reset" value="重置"/>
            <input type="button" value="返回" id="returns"/>
        </form>
    </div>
</body>
</html>
