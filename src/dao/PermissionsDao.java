package dao;

public interface PermissionsDao {

    /**
     * 根据id来删除用户权限
     * @param id
     * @return
     */
    boolean deletePermissions(int id);
}
