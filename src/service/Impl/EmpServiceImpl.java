package service.Impl;

import beanfactory.BeanFactory;
import dao.EmpDao;
import entity.Employee;
import service.EmpService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = (EmpDao) BeanFactory.getObject("empdao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");


    @Override
    public List<Employee> listEmpByConditions(int page,String empName, String empDept) {
        try {
            transaction.start();
            List<Employee> list = empDao.listEmpByCondition(page,empName,empDept);
            if(list != null){
                transaction.commit();
                return list;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Employee> listEmps() {
        try {
            transaction.start();
            List<Employee> list = empDao.listEmp();
            if(list != null){
                transaction.commit();
                return list;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> listEmpByPages(int page) {
        try {
            transaction.start();
            List<Employee> listEmp = empDao.listEmpByPage(page);
            if(listEmp != null){
                transaction.commit();
                return listEmp;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        EmpService empService = (EmpService) BeanFactory.getObject("empservice");
        List<Employee> list = empService.listEmps();
        System.out.println(list);
    }
}
