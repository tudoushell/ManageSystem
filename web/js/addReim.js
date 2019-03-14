window.onload = function (ev) {
    var back = document.getElementById("back");
    back.onclick = function (ev1) {
        location.href = "/web/manager/listReimburse.do?page=1";
    };
};