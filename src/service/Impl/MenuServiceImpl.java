package service.Impl;

import beanfactory.BeanFactory;
import dao.MenuDao;
import entity.Menu;
import service.MenuService;
import util.Transaction;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao  = (MenuDao) BeanFactory.getObject("menudao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public List<Menu> listMenu() {
        List<Menu> listMenu = menuDao.listMenu();
        if (listMenu != null){
            return listMenu;
        }
        return null;
    }
}
