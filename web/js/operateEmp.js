function del(empNo) {
    var flag = confirm("是否删除员工号为：" + empNo);
    if(flag){
        location.href = "/web/employee/delEmp.do?empNo=" + empNo;
    }
}
function updateDept(empNo) {
    location.href = "/web/employee/getEmp.do?empNo=" + empNo;
}

function detailEmp(empNo) {
    location.href = "/web/employee/detailEmp.do?empNo=" + empNo;
}