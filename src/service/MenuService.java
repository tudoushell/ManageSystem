package service;

import entity.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 列出所有菜单信息
     * @return
     */
    List<Menu> listMenu();
}
