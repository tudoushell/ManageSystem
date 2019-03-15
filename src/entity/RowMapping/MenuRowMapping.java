package entity.RowMapping;

import entity.Menu;
import util.RowMapperObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRowMapping implements RowMapperObject {
    @Override
    public Object rowMapperObject(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setId(rs.getInt("id"));
        menu.setMenuName(rs.getString("menu_name"));
        menu.setHrefUrl(rs.getString("href_url"));
        menu.setParentId(rs.getString("parent_id"));
        menu.setCreateTime(rs.getString("create_time"));
        return menu;
    }
}
