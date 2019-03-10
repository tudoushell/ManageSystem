package service;

import entity.Department;
import exception.DeptException;

import java.util.List;

public interface DeptService {
    /**
     * 列出所有的部门
     * @return
     */
    List<Department> listDept();

    /**
     * 通过page来列出条数
     * @param page
     * @return
     */
    List<Department> listDeptByPage(int page);


    /**
     * 添加部门
     * @param department
     * @return
     */
    boolean addDepts(Department department) throws DeptException;

    /**
     * 根据部门id来删除部门
     * @param deptId
     * @return
     */
    boolean delDept(String deptId);

    /**
     * 根据部门id来获取信息
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
