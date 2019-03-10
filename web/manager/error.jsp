<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-07
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
    <script>
        window.onload = function (ev) {
            alert("${result}");
            window.location.href = "/web/manager/${method}";
        };
    </script>
</head>
<body>

</body>
</html>
