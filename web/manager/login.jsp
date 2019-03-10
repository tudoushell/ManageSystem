<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            body{
                background-color: rgb(84, 84, 238);
            }
            #wrap{
                width: 400px;
                height: 255px;
                border: 1px solid #000;
                border-radius: 10px;
                background-color: #fff;
                margin: 0 auto;
                margin-top: 120px;
            }
            #wrap .title{
                width: 250px;
                height: 40px;
                text-align: center;
                margin: 0 auto;
                background-color: rgb(4, 163, 255);
                border-bottom-left-radius: 10px;
                border-bottom-right-radius: 10px;
            }
            .title > h2{
                font-weight: normal;
                color: #fff;
                letter-spacing: 6px;
            }
            .info{
                width: 50%;
                margin: 40px auto;
            }
            .btn{
                width: 60px;
                height: 21px;
                margin: 0 auto;
                margin-top: 10px;
            }
            .btn>button{
                color: #fff;
                width: 60px;
                height: 21px;
                background-color: rgb(4, 163, 255);
            }
        </style>
    </head>
    <body>
        <div id="wrap">
            <div class="title">
                <h2>NJWB管理系统</h2>
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