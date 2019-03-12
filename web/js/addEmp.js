window.onload = function (ev) {
    lay('#version').html('-v'+ laydate.v);
    //执行一个laydate实例
    laydate.render({
        elem: '#time' //指定元素
    });
    var back = document.getElementById("back");
    back.onclick = function (ev1) {
        location.href = "/web/manager/empList.do?page=1";
    };
};
