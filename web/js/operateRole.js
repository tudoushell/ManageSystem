
function del(roleId,roleName) {
    var flag = confirm("是否删除" + roleName +"?");
    if(flag){
        window.location.href = "/web/system/deleteRole.do?roleId=" + roleId;
    }
}

/**
 * 用于修改角色id
 * @param roleId
 */

function changeRole(roleId) {
    window.location.href = "/web/system/getRole.do?roleId=" + roleId;
}