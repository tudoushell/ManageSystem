package dao;

import entity.Reimburse;

import java.util.List;

public interface ReimburseDao {

    /**
     * 普通用户查询报销信息
     * @param page
     * @param reimName
     * @param reimType
     * @param reimStatus
     * @return
     */
    List<Reimburse> listReimburesByUser(int page,String reimName,String reimType ,String reimStatus);

    /**
     * 根据姓名来统计总条数
     * @param reimName
     * @return
     */
    int countReimburseByName(String reimName);

    /**
     * 根据姓名来列出报销记录(分页)
     * @param page
     * @param reimName
     * @return
     */
    List<Reimburse> listReimburseByName(int page,String reimName);

    /**
     * 根据报销的类型来统计个数
     * @param reimType
     * @param reimStatus
     * @return
     */
    int countReimburseByCondition(String reimType, String reimStatus);

    /**
     * 根据报销的类型和状态来查找
     * @return
     */
    List<Reimburse> listReimburseByCondition(int page , String reimType ,String reimStatus);

    /**
     * 进行分页列出数据
     * @param page
     * @return
     */
    List<Reimburse> listReimburseByPage(int page);
    /**
     * 列出所有的报销
     * @return
     */
    List<Reimburse> listReimburse();
}
