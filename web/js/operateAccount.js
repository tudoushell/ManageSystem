function del(empNo) {
    var flag = confirm("是否删除该帐号？");
    if(flag){
        location.href = "/web/system/delAccount.do?empNo=" + empNo;
    }
}
function updateAccount(empNo) {
    location.href = "/web/system/getAccount.do?empNo=" + empNo;
}