package service.Impl;

import beanfactory.BeanFactory;
import dao.SysConfigDao;
import entity.SysConfig;
import service.SysConfigService;
import util.Transaction;

import java.util.List;

public class SysConfigServiceImpl implements SysConfigService {
    private SysConfigDao sysConfigDao = (SysConfigDao) BeanFactory.getObject("sysconfigdao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public List<SysConfig> listRoleNameOrAccountStatus(String configType) {
        List<SysConfig> listConfig =  sysConfigDao.getRoleNameOrAccountStatus(configType);
        return listConfig;
    }

    public static void main(String[] args) {
        SysConfigService sysConfigService = new SysConfigServiceImpl();
        System.out.println(sysConfigService.listRoleNameOrAccountStatus("role_id"));
    }
}
