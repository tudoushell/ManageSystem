package dao;

import entity.Employee;

import java.util.List;

public interface EmpDao {

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
    boolean getEmpByNo(String empNo);

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
