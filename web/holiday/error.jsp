<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-04-21
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
    <script>
        window.onload = function (ev) {
            alert("${result}");
            location.href = "/web/holiday/${method}";
        };
    </script>
</head>
<body>

</body>
</html>
