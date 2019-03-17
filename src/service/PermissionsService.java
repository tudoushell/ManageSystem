package service;

import entity.Permissions;

public interface PermissionsService {

    /**
     * 修改权限
     * @param id
     * @param roleId
     * @param menuId
     * @return
     */
    boolean updatePermissions(int id, String roleId, String menuId);

    /**
     * 根据角色和菜单id来删除权限
     * @param roleId 角色id
     * @param menuId 菜单id
     * @return
     */
    boolean deletePerm(String roleId, String menuId);

    /**
     * 为角色添加的权限
     * @param perm
     * @return
     */
    boolean savePermissions(Permissions perm);
    /**
     * 根据id来删除用户权限
     * @return
     */
    boolean deletePermissions(int id);
}
