package service;

import entity.Role;
import exception.RoleException;

import java.util.List;

public interface RoleService {

    /**
     * 通过角色名来获取信息
     * @param roleName
     * @return
     */
    Role getRoleByName(String roleName);

    /**
     * 获取角色信息
     * @param roleId
     * @return
     */
    Role getRoleById(int roleId);

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    boolean saveRole(Role role);
    /**
     * 用于修改角色信息
     * @param role
     * @return
     */
    boolean updateRole(Role role) throws RoleException;
    /**
     * 通过id来删除角色信息
     * @param roleId
     * @return
     */
    boolean deleteRole(int roleId);
    /**
     * 列出角色信息
     * @return
     */
    List<Role> listRole() throws RoleException;
}
