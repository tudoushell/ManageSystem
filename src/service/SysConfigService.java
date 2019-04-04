package service;

import entity.SysConfig;

import java.util.List;

public interface SysConfigService {

    /**
     *  通过页面的信息来获取配置信息
     * @param configPageValue 页面信息(管理员或注销)
     * @return SysConfig
     */
    SysConfig getSysConfigInfo(String configPageValue);
    /**
     * 列出角色名或者用户状态
     * @param configType
     * @return
     */
    List<SysConfig> listRoleNameOrAccountStatus(String configType);

}
