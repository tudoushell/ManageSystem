function del(empNo) {
    var flag = confirm("是否删除该帐号？");
    if(flag){
        location.href = "/web/system/delAccount.do?empNo=" + empNo;
    }
}
function updateDept(empNo) {
    location.href = "/web/employee/getEmp.do?empNo=" + empNo;
}

function detailEmp(empNo) {
    location.href = "/web/employee/detailEmp.do?empNo=" + empNo;
}