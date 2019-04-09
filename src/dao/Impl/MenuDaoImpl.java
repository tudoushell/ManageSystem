package dao.Impl;

import dao.MenuDao;
import entity.Menu;
import entity.RowMapping.MenuRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {
    @Override
    public List<Menu> listMenu() {
        String sql = "SELECT * FROM menu";
        List<Object> list = JDBCUtil.executeQuery(sql,new MenuRowMapping());
        List<Menu> listMenu = new ArrayList<>();
        if(list != null){
            for (Object obj : list){
                listMenu.add((Menu) obj);
            }
            return listMenu;
        }
        return null;
    }

    public static void main(String[] args) {
        MenuDao menuDao = new MenuDaoImpl();
        System.out.println(menuDao.listMenu());
    }
}
