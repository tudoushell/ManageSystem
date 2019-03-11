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
    public List<Employee> listEmp() {
        String sql = "select * from employee";
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

    public static void main(String[] args) {
        EmpDaoImpl empDao = (EmpDaoImpl) BeanFactory.getObject("empdao");
        System.out.println(empDao.listEmp());
    }
}
