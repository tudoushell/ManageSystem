<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>管理系统</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
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
                                    ${user.userName}
                                    <a href="javascript:;" id="exit">退出</a>
                                    <%--超时退出--%>
                                    <%--<%--%>
                                        <%--session.setMaxInactiveInterval(10);--%>
                                    <%--%>--%>
                                </c:when>
                                <c:when test="${user == null}">
                                    未登录
                                </c:when>
                            </c:choose>
                        <c:if test="${user != null}">
                        </c:if>
                    </span>
                    <h2>XX管理系统</h2>
                </div>
                <div class="smalltitle">
                    <p>欢迎使用XX管理系统</p>
                </div>
            </div>
            <!-- 内容 -->
            <div id="content" class="clearfix">
                <!-- 左边内容 -->
                <div class="leftcontent">
                    <a href="#" id="hrM" class="mainManager">人事管理</a>
                    <ul class="hr">
                        <li><a href="list.do?page=1" id="moreDepart" class="otherManager">部门管理</a></li>
                        <li><a href="#" class="otherManager">员工管理</a></li>
                        <li><a href="#" class="otherManager">请假管理</a></li>
                    </ul>
                    <a href="#" id="financeM" class="mainManager">财务管理</a>
                    <ul class="finance">
                        <li><a href="#" class="otherManager">报销管理</a></li>
                    </ul>
                    <a href="#" id="sysM" class="mainManager">系统管理</a>
                    <ul class="systemManager">
                        <li><a href="#" class="otherManager">账户维护</a></li>
                        <li><a href="#" class="otherManager">角色管理</a></li>
                        <li><a href="#" class="otherManager">权限管理</a></li>
                        <li><a href="#" class="otherManager">密码重置</a></li>
                        <li><a href="#" class="otherManager">系统退出</a></li>
                    </ul>
                </div>
                <!-- 右边内容 -->
                <div class="rightcontent">
                    <div class="top_part">
                        <p>首页 >>部门管理</p>
                    </div>
                    <div class="bottom_content clearfix">
                        <div class="main_table">
                            <p><a href="addDept.jsp"><img id="add_table" src="img/add.png" alt="add">添加部门 </a></p>
                            <table>
                                <tbody>
                                    <tr>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                        <th>部门位置</th>
                                        <th>部门负责人</th>
                                        <th>操作列表</th>
                                    </tr>
                                    <c:forEach items="${deptLists}" var="listDept">
                                        <tr>
                                            <td>${listDept.deptId}</td>
                                            <td>${listDept.deptName}</td>
                                            <td>${listDept.deptLoc}</td>
                                            <td>${listDept.deptLeader}</td>
                                            <td>
                                                <a href="javascript:del('${listDept.deptId}');">
                                                    <img class="del_table" src="img/bullet_delete.png" alt="#">
                                                </a>
                                                <a href="javascript:changeDept('${listDept.deptId}');">
                                                    <img src="img/calendar_edit.png" alt="#">
                                                </a>
                                                <img src="img/detail.png" alt="#">
                                             </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="changePage">
                                <a href="list.do?page=1">首页</a>
                                <a href="list.do?page=${page - 1}">上一页</a>
                                <a href="list.do?page=${page + 1}">下一页</a>
                                <a href="list.do?page=${sum}">尾页</a>
                                <span>第${page}页</span>
                                <span>共${sum}页</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 底部 -->
            <div id="footer">
                <p>&copy;版权归属XX公司</p>
            </div>
        </div>
    </body>
</html>