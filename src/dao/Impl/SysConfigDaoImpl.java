package dao.Impl;

import dao.SysConfigDao;
import entity.RowMapping.SysConfigRowMapping;
import entity.SysConfig;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SysConfigDaoImpl implements SysConfigDao {

    @Override
    public List<SysConfig> getRoleNameOrAccountStatus(String configType) {
        String sql = "SELECT * FROM sys_config WHERE config_type=?";
        List<Object> list = JDBCUtil.executeQuery(sql, new SysConfigRowMapping(), configType);
        List<SysConfig> listSys = new ArrayList<>();
        if (list != null){
            Iterator<Object> it = list.iterator();
           while (it.hasNext()){
               listSys.add((SysConfig) it.next());
           }
        }
        return listSys;
    }

    public static void main(String[] args) {
        SysConfigDao s = new SysConfigDaoImpl();
        System.out.println(s.getRoleNameOrAccountStatus("role_id"));
    }
}
