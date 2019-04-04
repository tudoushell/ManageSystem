package dao;

import entity.SysConfig;

import java.util.List;

public interface SysConfigDao {
    /**
     * 通过页面的值(管理员或注销)来获取配置信息
     * @param configPageValue
     * @return
     */
    SysConfig getSysConfigInfo(String configPageValue);

    /**
     * 根据配置类型来获取角色名
     * @param configType
     * @return
     */
    List<SysConfig> getRoleNameOrAccountStatus(String configType);
}
