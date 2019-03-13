package dao.Impl;

import dao.ReimburseDao;
import entity.Reimburse;
import entity.ReimburseRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class ReimburseDaoImpl implements ReimburseDao {


    @Override
    public int countReimburseByCondition(String reimType, String reimStatus) {
        String sql = "SELECT * FROM reimburse WHERE reim_type=? AND reim_status=?";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimType,reimStatus);
        if(list != null){
            int count = list.size();
            return count;
        }
        return 0;
    }

    @Override
    public List<Reimburse> listReimburseByCondition(int page, String reimType, String reimStatus) {
        String sql = "SELECT * FROM reimburse WHERE reim_type=? AND reim_status=? LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimType,reimStatus,page);
        List<Reimburse> listReimburseCondition = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listReimburseCondition.add((Reimburse)obj);
            }
            return listReimburseCondition;
        }
        return null;
    }

    @Override
    public List<Reimburse> listReimburseByPage(int page) {
        String sql = "SELECT * FROM reimburse LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),page);
        List<Reimburse> listReimbursePages = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listReimbursePages.add((Reimburse) obj);
            }
            return  listReimbursePages;
        }
        return null;
    }

    @Override
    public List<Reimburse> listReimburse() {
        String sql = "SELECT * FROM  reimburse";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping());
        List<Reimburse> listReimburses = new ArrayList<>();
        if(list != null){
            for (Object objs : list){
                listReimburses.add((Reimburse) objs);
            }
            return listReimburses;
        }
        return null;
    }

    public static void main(String[] args) {
        ReimburseDao reimburseDao = new ReimburseDaoImpl();
        System.out.println(reimburseDao.countReimburseByCondition("clf","t"));
    }
}
