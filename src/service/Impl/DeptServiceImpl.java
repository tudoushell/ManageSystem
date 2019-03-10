package service.Impl;

import beanfactory.BeanFactory;
import dao.DeptDao;
import dao.Impl.DeptDaoImpl;
import entity.Department;
import exception.DeptException;
import service.DeptService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");
    private DeptDao deptDao = (DeptDao) BeanFactory.getObject("deptdao");


    @Override
    public  List<Department> listDept() {
        try {
            transaction.start();
            List<Department> list = deptDao.listDept();
            transaction.commit();
            if(list.size() > 0){
                return  list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        }

       return  null;
    }

    @Override
    public List<Department> listDeptByPage(int page) {
        try {
            transaction.start();
            List<Department> list = deptDao.listDeptByPage(page);
            if(list.size() > 0){
                return list;
            }
            transaction.commit();
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
    public boolean addDepts(Department ds) throws DeptException{
        if(ds.getDeptId() == null || "".equals(ds.getDeptId().trim())){
            throw new DeptException("部门不能为空");
        }
        //判断部门号是否有存在
        if(getDept(ds.getDeptId()) != null){
            throw  new DeptException("该部门号已存在");
        };
        try {
            transaction.start();
            DeptDao deptDao = new DeptDaoImpl();
            boolean flag = deptDao.addDept(ds);
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
    public boolean delDept(String deptId) {
        try {
            transaction.start();
            boolean flag  = deptDao.delDept(deptId);
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
    public Department getDept(String deptId) {
        try {
            transaction.start();
            Department department = deptDao.getDept(deptId);
            if(department != null){
                transaction.commit();
                return department;
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
    public boolean updateDept(Department department) {
        try {
            transaction.start();
            boolean flag = deptDao.updateDept(department);
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

    public static void main(String [] args){
         DeptService ds = new DeptServiceImpl();
         boolean flag = ds.updateDept(new Department("a","ddd","sdf","ds"));
//        Department dt = ds.getDept("a");
        System.out.println(flag);

    }

}
