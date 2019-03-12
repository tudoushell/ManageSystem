package dao.Impl;

import beanfactory.BeanFactory;
import dao.EmpDao;
import entity.Employee;
import entity.EmployeeRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Override
    public int countEmpByCondition(String empName, String empDept) {
        int count = 0;
        String sql = "SELECT * FROM employee WHERE emp_name LIKE ? and emp_dept=?";
        List<Object> list = JDBCUtil.executeQuery(sql,new EmployeeRowMapping(),empName + "%" , empDept );
        if(list != null){
            count = list.size();
        }
        return count;
    }

    @Override
    public List<Employee> listEmpByCondition(int page, String empName, String empDept) {
        String sql = "SELECT * FROM employee WHERE emp_name LIKE ? and emp_dept=? LIMIT ?,3";
        List<Employee> empList = new ArrayList<>();
        List<Object> list = JDBCUtil.executeQuery(sql , new EmployeeRowMapping() , empName + "%" , empDept ,page);
        if(list != null){
            for (Object lists : list){
                empList.add((Employee) lists);
            }
            return empList;
        }
        return null;
    }

    @Override
    public boolean saveEmp(Employee employee) {

        return false;
    }

    @Override
    public List<Employee> listEmp() {
        String sql = "SELECT * FROM employee";
        List<Employee> empList = new ArrayList<>();
        List<Object> list = JDBCUtil.executeQuery(sql,new EmployeeRowMapping());
        if(list != null){
            for (Object lists : list){
                empList.add((Employee) lists);
            }
            return empList;
        }
        return null;
    }

    @Override
    public List<Employee> listEmpByPage(int page) {
        String sql = "SELECT * FROM employee LIMIT ?,3";
        List<Employee> listEmp = new ArrayList<>();
        List<Object> list = JDBCUtil.executeQuery(sql,new EmployeeRowMapping(),page);
        if(list != null){
            for(Object lists : list){
                listEmp.add((Employee) lists);
            }
            return  listEmp;
        }
        return null;
    }

    public static void main(String[] args) {
        EmpDaoImpl empDao = (EmpDaoImpl) BeanFactory.getObject("empdao");
//        System.out.println(empDao.listEmpByCondition(0,"小明","就业部").size());
        System.out.println(empDao.countEmpByCondition("i","就业部"));
    }
}
