package service;

import entity.Role;
import exception.RoleException;

import java.util.List;

public interface RoleService {
    /**
     * 用于修改角色信息
     * @param role
     * @return
     */
    boolean updateRole(Role role);
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
