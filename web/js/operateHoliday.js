function del(holidayNo) {

    var flag = confirm("是否删除该请假记录？");
    if(flag) {
        location.href = "/web/holiday/delHoliday.do?holidayNo=" + holidayNo;
    }
}

function detailHoliday(holidayNo) {
    location.href = "/web/holiday/getHoliday.do?holidayNo=" + holidayNo;
}