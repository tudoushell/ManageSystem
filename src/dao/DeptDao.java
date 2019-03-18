package dao;

import entity.Department;
import exception.DeptException;

import java.util.List;

public interface DeptDao {
    /**
     * 列出所的有部门
     * @return
     */
    List<Department> listDept() throws DeptException;

    /**
     * 根据page数来列出页面
     * @return
     */
    List<Department>listDeptByPage(int page);

    /**
     * 添加部门
     * @param department
     * @return
     */
    boolean addDept(Department department);

    /**
     * 根据部门id 来删除 部门
     * @param deptId
     * @return
     */
    boolean delDept(String deptId);

    /**
     * 根据部门编号来获取部门信息
     * @param deptId
     * @return
     */

    Department getDept(String deptId);

    /**
     * 修改部门信息
     * @param department
     * @return
     */
    boolean updateDept(Department department);
}
