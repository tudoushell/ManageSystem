<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>管理系统</title>
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
    </head>
    <body>
        <div id="wrap">
            <!-- 标题 -->
            <div id="title">
                <div class="blue">
                    <span>
                        <%--判断用户是否登录--%>
                            <c:choose>
                                <c:when test="${user != null}">
                                    ${user.empName}
                                    <%--<a href="javascript:;" id="exit">退出</a>--%>
                                    <%--超时退出--%>
                                    <%--<%--%>
                                        <%--session.setMaxInactiveInterval(10);--%>
                                    <%--%>--%>
                                </c:when>
                            </c:choose>
                    </span>
                    <h2>公司管理系统</h2>
                </div>
                <div class="smalltitle">
                    <p>欢迎使用公司管理系统</p>
                </div>
            </div>
            <!-- 内容 -->
            <div id="content" class="clearfix">
                <!-- 左边内容 -->
                <div class="leftcontent">
                    <a href="#" id="hrM" class="mainManager">人事管理</a>
                    <ul class="hr">
                        <c:forEach items="${menuList}" var="menu">
                            <c:if test="${menu == 4}">
                                <li><a href="list.do?page=1" id="moreDepart" class="otherManager" target="contentPage">部门管理</a></li>
                            </c:if>
                            <c:if test="${menu == 5}">
                            <li><a href="empList.do?page=1" class="otherManager" target="contentPage">员工管理</a></li>
                            </c:if>
                            <c:if test="${menu == 6}">
                            <li><a href="listHoliday.do?page=1" class="otherManager" target="contentPage">请假管理</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <a href="#" id="financeM" class="mainManager">财务管理</a>
                    <ul class="finance">
                        <c:forEach items="${menuList}" var="menu">
                            <c:if test="${menu == 7}">
                             <li><a href="listReimburse.do?page=1" class="otherManager" target="contentPage">报销管理</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <a href="#" id="sysM" class="mainManager">系统管理</a>
                    <ul class="systemManager">
                        <c:forEach items="${menuList}" var="menu">
                            <c:if test="${menu == 8}">
                                <li><a href="listAccount.do?page=1" class="otherManager" target="contentPage">账户维护</a></li>
                            </c:if>
                            <c:if test="${menu == 9}">
                                <li><a href="/web/system/listRole.do" class="otherManager" target="contentPage">角色管理</a></li>
                            </c:if>
                            <c:if test="${menu == 10}">
                                <li><a href="listPrivileges.do?page=1" class="otherManager" target="contentPage">权限管理</a></li>
                            </c:if>
                        </c:forEach>
                        <li><a href="/web/system/recovery.jsp" class="otherManager" target="contentPage">密码重置</a></li>
                        <li id="exit"><a href="javascript:;" class="otherManager">系统退出</a></li>
                    </ul>
                </div>
                <!-- 右边内容 -->
                <div class="rightcontent">
                    <iframe name="contentPage" width="782px" height="410px" frameborder="0"></iframe>
                </div>
            </div>
            <!-- 底部 -->
            <div id="footer">
                <p>&copy;版权归属Binary</p>
            </div>
        </div>
    </body>
</html>