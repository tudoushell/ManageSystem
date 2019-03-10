<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-04
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
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
        <form action="add.do" method="post">
            <label for="deptid">部门编号:</label>
            <input type="text" id="deptid" name="deptid"/><br>
            <label for="deptname">部门姓名:</label>
            <input type="text" id="deptname" name="deptname"/><br>
            <label for="deptloc">部门位置:</label>
            <input type="text" id="deptloc" name="deptloc"/><br>
            <label for="deptleader">部门负责人:</label>
            <input type="text" id="deptleader" name="deptleader"/><br>
            <input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
            <input type="button" value="返回" id="returns"/>
        </form>
    </div>

</body>
</html>
