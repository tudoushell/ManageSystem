package dao;

import entity.Reimburse;

import java.util.List;

public interface ReimburseDao {


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
