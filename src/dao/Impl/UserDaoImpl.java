package dao.Impl;

import dao.UserDao;
import entity.RowMapping.UserRowMapping;
import entity.User;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public Boolean updataUserByEmpNo(User user) {
        String sql = "UPDATE user set user_pwd=?,role_id=?,account_status_id=? where emp_no=?";
        int flag = JDBCUtil.update(sql, user.getUserPwd(),
                             user.getRoleId(),
                             user.getAccountStautsId(),
                             user.getEmpNo());
        if (flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserByEmpNo(String empNo) {
        String sql = "DELETE FROM user where emp_no=?";
        int flag = JDBCUtil.update(sql,empNo);
        if (flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> listUserByConditionOrAll(String[] columnName, boolean flag, Object... args) {
        String sql = "SELECT * FROM user where 1=1";

        for(int i = 0; i < columnName.length; i++){
            if("".equals(columnName[i])){
                columnName[i] = "1";
                args[i] = "1";
            }
            sql += " AND "+ columnName[i] + " like ?";
        }
        if (flag){
            sql += " limit ?,3";
        }
        List<Object> obj = JDBCUtil.executeQuery(sql, new UserRowMapping(), args);
        List<User> userList = new ArrayList<>();
        if(obj != null){
            Iterator<Object> it = obj.iterator();
            while (it.hasNext()){
                userList.add((User) it.next());
            }
            return userList;
        }
        return null;
    }

    @Override
    public User getUserByRoleId(String roleId) {
        String sql = "SELECT * FROM user WHERE role_id=?";
        List<Object> list = JDBCUtil.executeQuery(sql, new UserRowMapping(), roleId);
        if(list != null) {
            return (User) list.get(0);
        }
        return null;
    }

    /**
     * 更改用户密码
     * @param userAccount
     * @param password
     * @return
     */
    @Override
    public boolean updateUser(String userAccount, String password) {
        String sql = "UPDATE user set user_pwd=? WHERE user_account=?";
        int flag = JDBCUtil.update(sql,password,userAccount);
        if(flag != 0){
            return true;
        }
        return false;
    }

    /**
     * 通过用户名来获取信息
     * @param username
     * @return
     */
    @Override
    public User getUser(String username,String password) {
        String sql = "SELECT * FROM user WHERE user_account=? AND user_pwd=?";
        User user = new User();
        List<Object> list =  JDBCUtil.executeQuery(sql, new UserRowMapping(),username,password);
        if(list != null ){
            user = (User) list.get(0);
            return user;
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUserPwd("123456");
        user.setRoleId("1");
        user.setAccountStautsId("1");
        user.setEmpNo("2");
        System.out.println(userDao.updataUserByEmpNo(user));

    }
}
