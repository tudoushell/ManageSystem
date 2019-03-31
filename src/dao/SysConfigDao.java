package dao;

import entity.SysConfig;

import java.util.List;

public interface SysConfigDao {

    /**
     * 根据配置类型来获取角色名
     * @param configType
     * @return
     */
    List<SysConfig> getRoleNameOrAccountStatus(String configType);
}
