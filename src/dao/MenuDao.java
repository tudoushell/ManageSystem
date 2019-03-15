package dao;

import entity.Menu;

import java.util.List;

public interface MenuDao {

    /**
     * 列出所有菜单信息
     * @return
     */
    List<Menu> listMenu();
}
