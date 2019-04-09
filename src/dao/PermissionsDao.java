package dao;

import entity.Permissions;

public interface PermissionsDao {
    /**
     * 修改权限
     * @param id
     * @param roleId
     * @param menuId
     * @return
     */
    boolean updatePermissions(int id, String roleId, String menuId);

    /**
     * 根据角色id和菜单id来删除
     * @param roleId
     * @param menuId
     * @return
     */
    boolean deletePermByRoleAndMenu(String roleId, String menuId);

    /**
     * 为角色添加权限
     * @param perm
     * @return
     */

    boolean savePermissions(Permissions perm);
    /**
     * 根据id来删除用户权限
     * @param id
     * @return
     */
    boolean deletePermissions(int id);
}
