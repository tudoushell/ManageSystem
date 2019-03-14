<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-14
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码重置</title>
    <meta charset="UTF-8">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #wrap{
            margin: 40px auto;
            text-align: center;
        }
        input{
            margin: 10px;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <form action="updateUser.do" method="post" accept-charset="UTF-8">
            <span>原密码：</span>
            <input type="password" name="oldPwd"><br>
            <span>新密码：</span>
            <input type="password" name="pwd"><br>
            <span>确认密码：</span>
            <input type="password" name="newPwd"><br>
            <input type="submit" value="修改">
            <input type="reset">
        </form>
    </div>
</body>
</html>
