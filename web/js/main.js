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
