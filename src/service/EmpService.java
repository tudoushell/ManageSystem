package service;

import entity.Employee;
import exception.EmpException;

import java.util.List;

public interface EmpService {


    /**
     * 根据条件来进行查询或列出所有员工信息
     * @param columnName
     * @param flag
     * @param args
     * @return
     * @throws EmpException
     */
    List<Employee> listEmpByConditionOrAll(String[] columnName, boolean flag, Object ... args) throws EmpException;

    /**
     * 判断部门中有没有员工
     * @param deptName
     * @return
     */
    boolean isEmpInDept(String deptName);
    /**
     * 更新员工信息
     * @param emp
     * @return
     */
    boolean updateEmp(Employee emp);

    /**
     * 根据员工号来删除信息
     * @param empNo
     * @return
     */
    boolean deleteEmp(String empNo);
    /**
     * 判断是否存在相同的员工编号
     * @param empNo
     * @return
     */
    Employee getEmpByNo(String empNo);

    /**
     * 添加员工
     * @param emp
     * @return
     */
    boolean saveEmps(Employee emp) throws EmpException;
    /**
     * 根据条件来统计符合标准的数据
     * @param empName
     * @param empDept
     * @return
     */
    int countEmpByConditions(String empName, String empDept) throws EmpException;
    /**
     * 根据条数来进行分页查询
     * @param page
     * @param empName
     * @param empDept
     * @return
     */
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
