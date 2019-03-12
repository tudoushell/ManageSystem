package dao;

import entity.Employee;

import java.util.List;

public interface EmpDao {


    /**
     * 根据条件来列出员工
     * @param empName 员工姓名
     * @param empDept 部门名称
     * @return
     */
    List<Employee> listEmpByCondition(int page,String empName , String empDept);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    boolean saveEmp(Employee employee);


    /**
     * 列出所有员工
     * @return
     */
    List<Employee> listEmp();

    /**
     * 根据页数来列举Emp数
     * @param page
     * @return
     */
    List<Employee>  listEmpByPage(int page);
}
