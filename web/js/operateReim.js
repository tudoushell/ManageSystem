function del(reimNo) {
    var flag = confirm("是否删除报销号为：" + reimNo);
    if(flag){
        location.href = "/web/employee/delReimburse.do?reimNo=" + reimNo;
    }
}

function updateReim(reimNo,reimStatus) {
    if(reimStatus == '已提交'){
        alert("该订单已提交不能修改！");
    }else {
        location.href = "/web/employee/getReimburse.do?reimNo=" + reimNo;
    }
}
function detailReim(reimNo){
        location.href = "/web/employee/detailReimburse.do?reimNo=" + reimNo;
}
