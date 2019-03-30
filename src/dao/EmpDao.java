package dao;

import entity.Employee;

import java.util.List;

public interface EmpDao {

    /**
     * 根据条件来列出的员工信息或列出所有员工信息
     * @param columnName 数据库列名
     * @param flag 为true进行分页
     * @param args 参数值
     * @return
     */
    List<Employee> listEmpByConditionOrAll(String[] columnName, boolean flag ,Object ... args);

    /**
     * 判断部门下有没有员工
     * @param deptName
     * @return
     */
    boolean isEmpInDetp(String deptName);

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    boolean updateEmp(Employee emp);

    /**
     * 根据员工的编号来删除
     * @param empNo
     * @return
     */
    boolean deleteEmp(String empNo);

    /**
     * 通过员工的编号判断是否重复
     * @param empNo
     * @return
     */
    Employee getEmpByNo(String empNo);

    /**
     * 根据员工的条件来统计条数
     * @param empName
     * @param empDept
     * @return
     */

    int countEmpByCondition(String empName, String empDept);

    /**
     * 根据条件来列出员工
     * @param empName 员工姓名
     * @param empDept 部门名称
     * @return
     */
    List<Employee> listEmpByCondition(int page,String empName , String empDept);

    /**
     * 添加员工
     * @param emp
     * @return
     */
    boolean saveEmp(Employee emp);


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
