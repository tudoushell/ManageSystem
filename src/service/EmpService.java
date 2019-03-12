package service;

import entity.Employee;

import java.util.List;

public interface EmpService {
    List<Employee> listEmpByConditions(int page,String empName, String empDept);
    /**
     * 列出所有员工
     * @return
     */
    List<Employee>  listEmps();

    /**
     * 用于分页显示
     * @param page
     * @return
     */
    List<Employee> listEmpByPages(int page);
}
