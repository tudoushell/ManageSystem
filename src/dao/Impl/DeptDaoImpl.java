package dao.Impl;

import dao.DeptDao;
import entity.Department;
import entity.RowMapping.DeptmentRowMapping;
import exception.DeptException;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    /**
     * 列出所有部门信息
     * @return
     */
    @Override
    public List<Department> listDept() throws DeptException {
        String sql = "SELECT * FROM dept";
        List<Department> listDepartment = new ArrayList<>();
        List<Object> list =  JDBCUtil.executeQuery(sql,new DeptmentRowMapping());
        if(list != null) {
            for(Object obj : list){
                listDepartment.add((Department) obj);
            }
            return listDepartment;
        }else {
            throw new DeptException("没有部门");
        }

    }

    /**
     * 列出部门条数
     * @param page
     * @return
     */
    @Override
    public List<Department> listDeptByPage(int page) {
        String sql = "SELECT * FROM dept limit ?,3";
        List<Department> listLimit = new ArrayList<>();
        List<Object> list = JDBCUtil.executeQuery(sql,new DeptmentRowMapping(),page);
        if(list != null){
            for (Object obj : list) {
                listLimit.add((Department) obj);
            }
            return listLimit;
        }
        return null;
    }

    /**
     * 添加部门信息
     * @param department
     * @return
     */
    @Override
    public boolean addDept(Department department) {
        String sql = "INSERT INTO dept values(?,?,?,?)";
        int flag = JDBCUtil.update(sql,department.getDeptId(),
                                       department.getDeptName(),
                                       department.getDeptLoc(),
                                       department.getDeptLeader());
        if(flag != 0){
            return true;
        }
        return false;
    }

    /**
     * 删除部门
     * @param deptId
     * @return
     */
    @Override
    public boolean delDept(String deptId) {
        String sql = "DELETE FROM dept where dept_id=?";
        int flag = JDBCUtil.update(sql,deptId);
        if(flag != 0){
            return  true;
        }
        return false;
    }

    /**
     * 根据部门编号来获取部门信息
     * @param deptId
     * @return
     */
    @Override
    public Department getDept(String deptId) {
        String sql = "SELECT * FROM dept WHERE dept_id=?";
        List<Object> list = JDBCUtil.executeQuery(sql,new DeptmentRowMapping(),deptId);
        if(list != null){
            return (Department)list.get(0);
        }
        return null;
    }

    @Override
    public boolean updateDept(Department department) {
        String sql = "UPDATE dept set dept_name=?,dept_loc=?,dept_leader=? where dept_id=?";
        int flag = JDBCUtil.update(sql,department.getDeptName(),
                                        department.getDeptLoc(),
                                        department.getDeptLeader(),
                                        department.getDeptId());
        if(flag != 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DeptDao deptDao = new DeptDaoImpl();
//        List<Department> list = deptDao.listDept();
//        System.out.println(list);
    }
}
