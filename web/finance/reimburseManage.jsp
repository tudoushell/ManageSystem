<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-13
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>报销管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/finacial.css">
    <script src="../js/operateEmp.js"></script>
</head>
<body>
<div class="top_part" style=" background-color: #95bfe0;">
    <p>首页 >>报销管理</p>
</div>
<div class="bottom_content clearfix">
    <div class="main_table">
        <div id="finSearch">
            <form action="listReimburse.do?page=1"  method="post" accept-charset="UTF-8">
                <span>报销类型：</span>
                <select name="reimType" id="Type">
                    <option value="请选择">请选择</option>
                    <option value="差旅费">差旅费</option>
                    <option value="招待费">招待费</option>
                    <option value="办公费">办公费</option>
                </select>
                <span>申请状态：</span>
                <select name="reimStatus" id="status">
                    <option value="请选择">请选择</option>
                    <option value="草稿">草稿</option>
                    <option value="已提交">已提交</option>
                </select>
                <input type="submit" value="查询" id="search">
            </form>
        </div>
        <p><a href="/web/employee/addEmp.jsp"><img id="add_table" src="../img/add.png" alt="add">添加报销</a></p>
        <table>
            <tbody>
            <tr>
                <th>报销编号</th>
                <th>申请人</th>
                <th>报销类型</th>
                <th>金额</th>
                <th>申请时间</th>
                <th>申请状态</th>
                <th>操作列表</th>
            </tr>
            <c:forEach items="${listReimburse}" var="reim">
                <tr>
                    <td>${reim.reimNo}</td>
                    <td>${reim.reimName}</td>
                    <td>${reim.reimType}</td>
                    <td>${reim.reimMoney}</td>
                    <td>${reim.createTime}</td>
                    <td>${reim.reimStatus}</td>
                    <td>
                        <a href="javascript:del('${reim.reimNo}');">
                            <img class="del_table" src="../img/bullet_delete.png" alt="#">
                        </a>
                        <a href="javascript:updateDept('${reim.reimNo}');">
                            <img src="../img/calendar_edit.png" alt="#">
                        </a>
                        <img src="../img/detail.png" alt="#">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="changePage">
            <a href="listReimburse.do?page=1">首页</a>
            <a href="listReimburse.do?page=${page - 1}&empName=${empNames}&empDept=${empDepts}">上一页</a>
            <a href="listReimburse.do?page=${page + 1}&empName=${empNames}&empDept=${empDepts}">下一页</a>
            <a href="listReimburse.do?page=${allPage}&empName=${empNames}&empDept=${empDepts}">尾页</a>
            <span>第${page}页</span>
            <span>共${allPage}页</span>
        </div>
    </div>
</div>
</body>
</html>
