lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
    elem: '#startTime',//指定元素
    trigger: 'click'
});
laydate.render({
    elem: '#endTime',//指定元素
    trigger: 'click'
});