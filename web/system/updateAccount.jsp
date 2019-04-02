<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-04-02
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改帐户信息</title>
    <meta charset="UTF-8">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #wrap{
            width: 500px;
            margin: 20px auto;
            text-align: center;
        }
        .btn{
            margin-top: 10px;
        }
        input{
            margin-bottom: 10px;
        }
    </style>

</head>
<body>
    <div id="wrap">
        <form action="#" method="post" accept-charset="UTF-8">
           <span>账号：</span>
            <input type="text" name="account" value="${userAccount}"><br>
            <span>密码：</span>
            <input type="password" name="pwd"><br>
            <span>确认密码：</span>
            <input type="password" name="newPwd"><br>
            <span>员工编号：</span>
            <input type="text" name="empNo" value="${empNo}"><br>
            <span>员工姓名：</span>
            <input type="text" name="empName" value="${empName}"><br>
            <span>状态：</span>
            <select name="accountStatus">
                <c:forEach items="${listAccountStatus}" var="status">
                    <c:choose>
                        <c:when test="${status.configPageValue == accountStatus}">
                            <option value="${status.configPageValue}" selected>${status.configPageValue}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${status.configPageValue}">${status.configPageValue}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <span>角色：</span>
            <select name="roleName">
                <c:forEach items="${listRoleName}" var="roleNames">
                    <c:choose>
                        <c:when test="${roleNames.configPageValue == roleName}">
                            <option value="${roleNames.configPageValue}" selected>${roleNames.configPageValue}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${roleNames.configPageValue}">${roleNames.configPageValue}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select><br>
            <div class="btn">
                <input type="submit" value="保存">
                <input type="reset" value="重置">
            </div>
        </form>
    </div>
</body>
</html>
