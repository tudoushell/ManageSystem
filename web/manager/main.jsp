<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>管理系统</title>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            .clearfix::after,.clearfix::before{
                content: "";
                display: table;
                clear: both;
            }
            #wrap{
                width: 950px;
                margin: 0 auto;

            }
            #title{
                width: 950px;
                height: 80px;
            }
            #title .blue{
                height: 45px;
                background-color: #0070a2;
            }
            .blue > h2{
                font-weight: normal;
                line-height: 45px;
                color: #fff;
                margin-left: 10px;
                display: inline-block;
            }
            .blue > span{
                color: #fff;
                font-size: 20px;
                float: right;
                line-height: 45px;
                margin-right: 10px;
            }
            #title > .smalltitle{
                height: 35px;
                text-align: center;
                border: 1px solid gainsboro;
            }
            .smalltitle > p{
                line-height: 35px;
            }
            #exit{
                color: white;
                font-size: 17px;

            }
            /************** 标题结束 *****************/
            #content{
                width: 948px;
                border: 1px solid gainsboro;
            }
            #content .leftcontent{
                float: left;
                width: 165px;
                border-right: 1px solid gainsboro;
            }
            /* 左边内容 */
            .leftcontent > .hr{
                list-style-type: none;
                margin-top: 10px;
                margin-left: 20px;
            }
            a{
                text-decoration: none;
            }
            .mainManager{
                display: block;
                color: #616378;
                font-size: 16px;
                font-weight: bold;
                margin: 15px 0 0 15px;
            }
            .otherManager{
                display: block;
                color: #616378;
                font-size: 14px;
                margin: 10px 0 10px 40px;
            }

            .leftcontent > .finance{
                list-style-type: none;
                margin-top: 10px;
                margin-left: 20px;
            }

            .leftcontent > .systemManager{
                list-style-type: none;
                margin-top: 10px;
                margin-left: 20px;
            }

            /* 右边内容 */
            .rightcontent{
                width: 782px;
                float: right;
                /*display: none;*/
            }
            .rightcontent .top_part{
                height: 30px;
                background-color: #95bfe0;
            }
            .top_part > p{
                line-height: 30px;
                font-size: 14px;
            }

            .bottom_content{
                height: 291px;
                padding-bottom: 70px;
                background-color: #edeff0;
            }

            .main_table{
                width: 600px;
                margin: 0 auto;
            }
            .main_table > p {
                margin: 10px 0;
                cursor: pointer;
                font-size: 14px;
            }
            .main_table > p > a >img{
                width: 17px;
                height: 17px;
                margin-right: 10px
            }
            table{
                text-align: center;
                border-collapse: collapse;      
            }
            th,td,tr{
                width: 125px;
                height: 30px;
                border: 5px solid #e3e3e3;

            }
            th{
                background-color: #ffeed0;
            }
            table img{
                width: 17px;
                height: 17px;
            }

            /*新添加的*/
            .changePage{
                margin-top: 10px;
                text-align: center;
            }
            .changePage > a{
                color: #000000;
                margin: 0 5px;
            }

            /*********** 主要内容结束 ***********/
            #footer{
                height: 38px;
                border: 1px solid gainsboro;
            }
            #footer > p{
                text-align: center;
                font-size: 14px;
                line-height: 38px;
            }
        </style>
        <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
        <script>
            $(function(){
                // 标题的滑动
                $("#hrM").click(function(){
                    $(".hr").stop().slideToggle();
                });

                $("#financeM").click(function(){
                    $(".finance").stop().slideToggle();
                });

                $("#sysM").click(function(){
                    $(".systemManager").stop().slideToggle();
                });

                //添加表格
                // $('#add_table').click(function(){
                //     $('tbody').append("<tr><td></td><td></td><td></td><td></td><td>"+
                //         "<img class='del_table' src='img/bullet_delete.png' alt='#'>"+
                //         " <img src='img/calendar_edit.png' alt='#'> <img src='img/detail.png' alt='#'>"+"</td></tr>");
                // });

                // 删除表格
                // $('.del_table').click(function(){
                //    confirm("")
                // });

                //点击人事管理出现表格
                $('#moreDepart').click(function () {
                    $('.rightcontent').css("display","block");
                });

                //退出事件
                $('#exit').click(function () {
                    var flag = confirm("是否退出？");
                    if(flag){
                        //跳转退出页面
                        window.location.href = "exit.jsp";
                        window.event.returnValue = false;
                    }
                });
            });
            // 删除部门
            function del(deptid){
                var flag = confirm("是否删除" + deptid);
                if(flag){
                    window.location.href = "/web/manager/del.do?deptId=" + deptid;
                }
            }
            //修改部门
            function changeDept(deptid) {
                window.location.href = "/web/manager/get.do?deptId=" + deptid;
            }
        </script>
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
                    <h2>南京网博教育集团</h2>
                </div>
                <div class="smalltitle">
                    <p>欢迎使用网博管理系统</p>
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
                <p>&copy;版权归属南京网博江北总部</p>
            </div>
        </div>
    </body>
</html>