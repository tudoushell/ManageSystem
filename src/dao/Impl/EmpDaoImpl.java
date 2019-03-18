package dao.Impl;

import beanfactory.BeanFactory;
import dao.EmpDao;
import entity.Employee;
import entity.RowMapping.EmployeeRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Override
    public boolean isEmpInDetp(String deptName) {
        String sql = "SELECT * FROM employee WHERE emp_dept=?";
        List<Object> list = JDBCUtil.executeQuery(sql,new EmployeeRowMapping(), deptName);
        if(list != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmp(Employee emp) {
        String sql = "UPDATE employee set emp_name=?," +
                                            "emp_dept=?," +
                                            "sex=?," +
                                            "entry_time=?" +
                                            "WHERE emp_no=?";
        int flag = JDBCUtil.update(sql,emp.getEmpName(),
                            emp.getEmpDept(),
                            emp.getSex(),
                            emp.getEntryTime(),
                            emp.getEmpNo());
        if(flag != 0){
            return true;
        }
            return false;
    }

    @Override
    public boolean deleteEmp(String empNo) {
        String sql = "DELETE FROM employee WHERE emp_no=?";
        int flag = JDBCUtil.update(sql,empNo);
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmpByNo(String empNo) {
        String sql = "SELECT * FROM employee WHERE emp_no=?";
        List<Employee> listEmpNo = new ArrayList<>();
        List<Object> obj = JDBCUtil.executeQuery(sql,new EmployeeRowMapping(),empNo);
        if(obj != null){
            for(Object objs : obj){
                listEmpNo.add((Employee) objs);
            }
            return listEmpNo.get(0);
        }else {
            return null;
        }
    }

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
    public boolean saveEmp(Employee emp){
        String sql = "INSERT INTO employee(emp_no," +
                                            "emp_name," +
                                            "emp_dept," +
                                            "sex,education," +
                                            "email," +
                                            "phone," +
                                            "entry_time," +
                                            "create_time) " +
                                            "values(?,?,?,?,?,?,?,?,?)";

        int flag =  JDBCUtil.update(sql,emp.getEmpNo(),
                                        emp.getEmpName(),
                                        emp.getEmpDept(),
                                        emp.getSex(),
                                        emp.getEducation(),
                                        emp.getEmail(),
                                        emp.getPhone(),
                                        emp.getEntryTime(),
                                        emp.getCreateTime());
        if(flag != 0){
            return true;
        }
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
//        boolean flag = empDao.updateEmp(new Employee("123","1","1","1","1","1","1","1","1"));
        System.out.println(empDao.isEmpInDetp("就业部"));
//        System.out.println(flag);
    }
}
