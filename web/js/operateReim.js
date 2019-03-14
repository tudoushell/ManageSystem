function del(reimNo) {
    var flag = confirm("是否删除报销号为：" + reimNo);
    if(flag){
        location.href = "/web/employee/delReimburse.do?reimNo=" + reimNo;
    }
}
function updateDept(reimNo) {
    location.href = "/web/employee/updateReimburse.do?reimNo=" + reimNo;
}
