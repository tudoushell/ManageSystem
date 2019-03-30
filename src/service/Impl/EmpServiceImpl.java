package service.Impl;

import beanfactory.BeanFactory;
import dao.EmpDao;
import entity.Employee;
import exception.EmpException;
import service.EmpService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService{
    private EmpDao empDao = (EmpDao) BeanFactory.getObject("empdao");
    private Transaction transaction  = (Transaction) BeanFactory.getObject("transaction");


    @Override
    public List<Employee> listEmpByConditionOrAll(String[] columnName, boolean flag, Object... args) throws EmpException {
        List<Employee> listEmp = empDao.listEmpByConditionOrAll(columnName,flag,args);
        if (listEmp == null){
            throw new EmpException("没有员工信息");
        }
        return listEmp;
    }

    @Override
    public boolean isEmpInDept(String deptName) {
        return empDao.isEmpInDetp(deptName);
    }

    @Override
    public boolean updateEmp(Employee emp) {
        try {
            transaction.start();
            boolean flag = empDao.updateEmp(emp);
            if(flag){
                transaction.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmp(String empNo) {
        try {
            transaction.start();
            boolean flag = empDao.deleteEmp(empNo);
            if(flag){
                transaction.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmpByNo(String empNo) {
        Employee emp = empDao.getEmpByNo(empNo);
        if (emp != null){
            return emp;
        }
        return null;
    }

    @Override
    public boolean saveEmps(Employee emp) throws EmpException{
        //对用户的输入的数据进行判断
        if(emp.getEmpNo() == null || emp.getEmpNo().trim().length() == 0
                || emp.getCreateTime().trim().length() == 0 || emp.getEmpName().trim().length() == 0){
            throw new EmpException("输入的数据有误！");
        }
        if(getEmpByNo(emp.getEmpNo()) != null){
            throw new EmpException("员工编号已存在！");
        }
        try {
            transaction.start();
            boolean flag = empDao.saveEmp(emp);
            if(flag){
                transaction.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int countEmpByConditions(String empName, String empDept) throws  EmpException{
        try {
            transaction.start();
            int count = empDao.countEmpByCondition(empName,empDept);
            if(count != 0 ){
                transaction.commit();
                return count;
            }else{
                throw new EmpException("没有此人");
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

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


    public static void main(String[] args) throws EmpException {
        EmpService empService = (EmpService) BeanFactory.getObject("empservice");
//        List<Employee> list = empService.listEmps();
//        int list = empService.countEmpByConditions("小","就业部");
//        System.out.println(list);
//        boolean flag = empService.updateEmp(new Employee("123","2","1","1","1","1","1","1","1"));
//        System.out.println(flag);
        System.out.println(empService.listEmpByConditionOrAll(new String[]{"emp_name",""},true,"adf","1",0));
    }
}
