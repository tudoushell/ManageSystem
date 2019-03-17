    function del(id) {

        var flag = confirm("是否删除该角色权限？");
            if(flag){
                location.href = "/web/system/delPerm.do?id=" + id;
            }
    }

    function updatePerm(roleId,menuId,id) {
        // location.href = "/web/system/getPerm.do?roleId=" + roleId + "&menuId=" + menuId + "&roleName=" + roleName + "&menuName=" + menuName;
        location.href = "/web/system/getPerm.do?roleId=" + roleId + "&menuId=" + menuId + "&id=" + id;
    }



