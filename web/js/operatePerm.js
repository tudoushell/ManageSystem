    function del(id) {
        var flag = confirm("是否删除该角色权限？");
            if(flag){
                location.href = "/web/system/delPerm.do?id=" + id;
            }
    }

    function updateDept(empNo) {
        location.href = "/web/employee/getEmp.do?empNo=" + empNo;
    }



