<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-15
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>权限管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/finacial.css">
    <script src="../js/operateReim.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 >>权限管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="finSearch">
            <form action="listReimburse.do?page=1"  method="post" accept-charset="UTF-8">
                <span>角色：</span>
                <select name="reimType" id="Type">
                    <option value="请选择">请选择</option>
                    <option value="差旅费">差旅费</option>
                    <option value="招待费">招待费</option>
                    <option value="办公费">办公费</option>
                </select>
                <span>菜单：</span>
                <select name="reimStatus" id="status">
                    <option value="请选择">请选择</option>
                    <option value="草稿">草稿</option>
                    <option value="已提交">已提交</option>
                </select>
                <input type="submit" value="查询" id="search">
            </form>
        </div>
        <p><a href="/web/finance/addReimburse.jsp"><img id="add_table" src="../img/add.png" alt="add">添加权限</a></p>
        <table>
            <tbody>
            <tr>
                <th>角色ID</th>
                <th>角色名称</th>
                <th>菜单ID</th>
                <th>菜单名称</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${listReimburse}" var="reim">
                <tr>
                    <td>${reim.reimNo}</td>
                    <td>${reim.reimName}</td>
                    <td>${reim.reimType}</td>
                    <td>${reim.reimMoney}</td>
                    <td>
                        <a href="javascript:del('${reim.reimNo}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updateReim('${reim.reimNo}','${reim.reimStatus}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="listReimburse.do?page=1&reimType=${reimType}&reimStatus=${reimStatus}">首页</a>
            <a href="listReimburse.do?page=${page - 1}&reimType=${reimType}&reimStatus=${reimStatus}">上一页</a>
            <a href="listReimburse.do?page=${page + 1}&reimType=${reimType}&reimStatus=${reimStatus}">下一页</a>
            <a href="listReimburse.do?page=${allPage}&reimType=${reimType}&reimStatus=${reimStatus}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>
