package service;

import entity.Reimburse;
import exception.ReimburseException;

import java.util.List;

public interface ReimburseService {

    /**
     * 根据姓名来统计报销数量
     * @param reinName
     * @return
     */
    int countReimburseByNames(String reinName);

    /**
     * 根据姓名来进行报销分页
     * @param page
     * @param reinName
     * @return
     */
    List<Reimburse> listReimburseByNames(int page,String reinName);
    /**
     * 根据条件来统计报销的数量
     * @param reimType
     * @param reimStatus
     * @return
     */
    int countReimburseByCondition(String reimType,String reimStatus) throws ReimburseException;

    /**
     * 根据条件来进行报销分页
     * @param page
     * @param reimType
     * @param reimStatus
     * @return
     */
    List<Reimburse> listReimburseByCondition(int page,String reimType,String reimStatus);

    /**
     * 分页进行显示
     * @param page
     * @return
     */
    List<Reimburse> listReimburseByPage(int page);

    /**
     * 列出所有报销记录
     * @return
     */
    List<Reimburse> listReimburse();
}
