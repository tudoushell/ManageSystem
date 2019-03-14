<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-02
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.removeAttribute("user");
    response.sendRedirect("/web/manager/login.jsp");
%>

</body>
</html>
