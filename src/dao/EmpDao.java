package dao;

import entity.Employee;

import java.util.List;

public interface EmpDao {

    /**
     * 列出所有员工
     * @return
     */
    List<Employee> listEmp();
}
