<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2019-03-04
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
    <style>
        #wrap{
            text-align: left;
            width: 340px;
            margin: 0 auto;

        }
        form > input{
            margin-bottom: 10px;
        }
        #message{
            color: red;
            font-size: 12px;
        }
    </style>
    <script>
        window.onload = function () {
          var returns = document.getElementById("returns");
          returns.onclick = function (ev1) {
                window.location.href = "list.do?page=1";
          };
            /**
             * 通过AJAX 来进行判断部门编号是否存在
             * @type {HTMLElement}
             */
          var deptId = document.getElementById("deptid");
            deptId.onblur = function () {
              var values = this.value;
              var request;
              if(window.XMLHttpRequest){
                    request = new XMLHttpRequest();
                }else {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }
              var method = "GET";
              var url = "checkDept.do?deptId=" + values;
              request.open(method,url);
              request.send();
              //获取状态
              request.onreadystatechange = function (ev) {
                    if(request.readyState == 4){
                        if(request.status == 200 || request.status == 302){
                            document.getElementById("message").innerHTML = request.responseText;
                        }
                    }
              };
          };
        };
    </script>
</head>
<body>
    <div id="wrap">
        <form action="add.do" method="post">
            <label for="deptid">部门编号:</label>
            <input type="text" id="deptid" name="deptid"/>
            <span id="message"></span><br>
            <label for="deptname">部门姓名:</label>
            <input type="text" id="deptname" name="deptname"/><br>
            <label for="deptloc">部门位置:</label>
            <input type="text" id="deptloc" name="deptloc"/><br>
            <label for="deptleader">部门负责人:</label>
            <input type="text" id="deptleader" name="deptleader"/><br>
            <input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
            <input type="button" value="返回" id="returns"/>
        </form>
    </div>
</body>
</html>
