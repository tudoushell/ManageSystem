<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加报销单</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/addReim.css">
    <script src="../js/addReim.js"></script>
</head>
<body>
    <div id="wrap">
        <form action="#" method="post">
            <div id="type">
                <span>报销类型：</span>
                <select name="reimType">
                    <option>请选择</option>
                    <option value="差旅费">差旅费</option>
                    <option value="招待费">招待费</option>
                    <option value="办公费">办公费</option>
                </select><br>
            </div>
            <span>摘要：</span>
            <textarea></textarea><br>
            <span>金额：</span>
            <input type="text" name="cost"><br>
            <input type="submit" name="draft" value="草稿">
            <input type="submit" name="submit" value="提交">
            <input type="reset">
            <input type="button" value="返回" id="back">
        </form>
    </div>
</body>
</html>