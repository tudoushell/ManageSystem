package service;

import entity.Employee;

import java.util.List;

public interface EmpService {
    /**
     * 列出所有员工
     * @return
     */
    List<Employee>  listEmps();
}
