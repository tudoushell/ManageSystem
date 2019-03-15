package dao.Impl;

import dao.ReimburseDao;
import entity.Reimburse;
import entity.RowMapping.ReimburseRowMapping;
import util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class ReimburseDaoImpl implements ReimburseDao {


    @Override
    public boolean updateReimburse(Reimburse reim) {
        String sql = "UPDATE reimburse SET reim_type=?," +
                                            "reim_abstract=?," +
                                            "reim_money=?," +
                                             "reim_status=? " +
                                             "WHERE reim_no=?";

        int flag = JDBCUtil.update(sql,reim.getReimType(),
                                        reim.getReimAbstract(),
                                        reim.getReimMoney(),
                                        reim.getReimStatus(),
                                        reim.getReimNo());
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveReimburse(Reimburse reim) {
        String sql = "INSERT INTO reimburse(reim_no," +
                                            "reim_name," +
                                            "reim_type," +
                                            "reim_money," +
                                            "reim_create_time," +
                                            "reim_status," +
                                            "reim_abstract) VALUES(?,?,?,?,?,?,?)";

        int flag = JDBCUtil.update(sql,reim.getReimNo(),
                                        reim.getReimName(),
                                        reim.getReimType(),
                                        reim.getReimMoney(),
                                        reim.getCreateTime(),
                                        reim.getReimStatus(),
                                        reim.getReimAbstract());
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public int getReimburseMaxId() {
        String sql = "SELECT Max(id) FROM reimburse";
        int count = JDBCUtil.executeCountQuery(sql);
        return count;
    }

    @Override
    public Reimburse getReimburseByReimNo(String reimNo) {
        String sql = "SELECT * FROM reimburse where reim_no=?";
        List<Object> obj = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimNo);
        if(obj != null){
             Reimburse reimburse = (Reimburse) obj.get(0);
             return  reimburse;
        }
        return null;
    }

    @Override
    public boolean deleteReimburseByReimNo(String reimNo) {
        String sql = "DELETE FROM reimburse WHERE reim_no=?";
        int flag  = JDBCUtil.update(sql,reimNo);
        if(flag != 0){
            return true;
        }
        return false;
    }

    @Override
    public int countReimburseByUser(String reimName, String reimType, String reimStatus) {
        String sql = "SELECT * FROM reimburse WHERE reim_name=? AND reim_type=? AND reim_status=?";
        List<Object> obj = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimName,reimType,reimStatus);
        if(obj != null){
            return obj.size();
        }
        return 0;
    }

    @Override
    public List<Reimburse> listReimburseByUser(int page, String reimName, String reimType, String reimStatus) {
        String sql = "SELECT * FROM reimburse WHERE reim_name=? AND reim_type=? AND reim_status=? LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimName,reimType,reimStatus,page);
        List<Reimburse> listReiburse = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listReiburse.add((Reimburse) obj);
            }
            return listReiburse;
        }
        return null;
    }

    @Override
    public int countReimburseByName(String reimName) {
        String sql = "SELECT * FROM reimburse WHERE reim_name=?";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimName);
        if(list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public List<Reimburse> listReimburseByName(int page, String reimName) {
        String sql = "SELECT * FROM reimburse WHERE reim_name=? LIMIT ?,3";
        List<Object> list = JDBCUtil.executeQuery(sql,new ReimburseRowMapping(),reimName,page);
        List<Reimburse> listReimburseByName = new ArrayList<>();
        if(list != null){
            for(Object obj : list){
                listReimburseByName.add((Reimburse) obj);
            }
            return listReimburseByName;
        }
        return null;
    }

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
//        System.out.println(reimburseDao.saveReimburse(new Reimburse("sdaf","adsf","fadsf",324,"sdf","dsf","adsf")));
        System.out.println(reimburseDao.getReimburseMaxId());
    }
}
