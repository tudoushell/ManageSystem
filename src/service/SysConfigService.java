package service;

import entity.SysConfig;

import java.util.List;

public interface SysConfigService {

    /**
     * 列出角色名或者用户状态
     * @param configType
     * @return
     */
    List<SysConfig> listRoleNameOrAccountStatus(String configType);

}
