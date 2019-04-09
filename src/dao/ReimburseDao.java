package dao;

import entity.Reimburse;

import java.util.List;

public interface ReimburseDao {
    /**
     * 通过条件列出报销信息或者全部信息
     * @param columnName
     * @param flag
     * @param args
     * @return
     */
    List<Reimburse> listReimburseByConditionOrAll(String[] columnName, boolean flag, Object ... args);

    /**
     * 更新报销单的信息
     * @param reim
     * @return
     */
    boolean updateReimburse(Reimburse reim);

    /**
     * 存储报销单
     * @param reim 报销单
     * @return boolean
     */
    boolean saveReimburse(Reimburse reim);

    /**
     * 获取报销单的最大主键值
     * @return
     */
    int getReimburseMaxId();

    /**
     * 根据报销编号来获取报销信息
     * @param reimNo 报销编号
     * @return Reimbures
     */
    Reimburse getReimburseByReimNo(String reimNo);

    /**
     * 根据报销编号来删除记录
     * @param reimNo 报销编号
     * @return  boolean
     */
    boolean deleteReimburseByReimNo(String reimNo);

    /**
     * 根据用户查询来列出报销条数
     * @param reimName  报销姓名
     * @param reimType  报销的类型
     * @param reimStatus 报销的状态
     * @return  int
     */
    int countReimburseByUser(String reimName,String reimType ,String reimStatus);

    /**
     * 普通用户查询报销信息
     * @param page  页面数
     * @param reimName 报销姓名
     * @param reimType 报销的类型
     * @param reimStatus  报销的状态
     * @return  List<Reimburse>
     */
    List<Reimburse> listReimburseByUser(int page,String reimName,String reimType ,String reimStatus);

    /**
     * 根据姓名来统计总条数
     * @param reimName  报销姓名
     * @return  报销人的记录条数
     */
    int countReimburseByName(String reimName);

    /**
     * 根据姓名来列出报销记录(分页)
     * @param page   页面数
     * @param reimName 报销姓名
     * @return     List<Reimburse>
     */
    List<Reimburse> listReimburseByName(int page,String reimName);

    /**
     * 根据报销的类型来统计个数
     * @param reimType  报销的类型
     * @param reimStatus  报销的状态
     * @return  根据条件来统计报销的条数
     */
    int countReimburseByCondition(String reimType, String reimStatus);

    /**
     * 根据报销的类型和状态来查找
     * @return  List<Reimburse>
     */
    List<Reimburse> listReimburseByCondition(int page , String reimType ,String reimStatus);

    /**
     * 进行分页列出数据
     * @param page 页面数
     * @return List<Reimburse>
     */
    List<Reimburse> listReimburseByPage(int page);
    /**
     * 列出所有的报销
     * @return  List<Reimburse>
     */
    List<Reimburse> listReimburse();
}
