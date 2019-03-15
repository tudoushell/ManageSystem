package dao;

import entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 列出所有角色信息
     * @return
     */
    List<Role> listRole();
}
