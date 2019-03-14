package service;

import entity.Reimburse;
import exception.ReimburseException;

import java.util.List;

public interface ReimburseService {

    /**
     * 根据报销编号来获取记录
     * @param reimNo 报销编号
     * @return
     */
    Reimburse getReimburseByReimNo(String reimNo);

    /**
     * 根据报销编号来删除
     * @param reimNo 报销编号
     * @return boolean
     */
    boolean deleteReimburseByReimNo(String reimNo);

    /**
     * 普通用户查询条件的条数
     * @param reimName
     * @param reimType
     * @param reimStatus
     * @return
     */
    int countReimburseByUser(String reimName,String reimType,String reimStatus) throws ReimburseException;
    /**
     * 用于普通用户查询
     * @param page
     * @param reimName
     * @param reimType
     * @param reimStatus
     * @return
     * @throws ReimburseException
     */
    List<Reimburse> listReimburseByUser(int page,String reimName,String reimType,String reimStatus)throws ReimburseException;
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
