package service;

import entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 列出角色信息
     * @return
     */
    List<Role> listRole();
}
