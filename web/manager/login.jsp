<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" type="text/css" href="css/user.css">
    </head>
    <body>
        <div id="wrap">
            <div class="title">
                <h2>管理系统</h2>
            </div>
            <div class="info">
                <form action="login.do" method="post" accept-charset="UTF-8">
                    <label for="userName">用户名：</label>
                    <input type="text" name="userName" id="userName" placeholder="用户名"><br>
                    <label for="password">密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="text" name="password" id="password" placeholder="密码"><br>
                    <label for="verification">验证码：</label>
                    <input type="text" name="verification" id="verification">
                    <div class="btn"><button>登 录</button></div>
                </form>
            </div>
        </div>
    </body>
</html>