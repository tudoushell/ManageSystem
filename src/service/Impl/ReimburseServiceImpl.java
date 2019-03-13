package service.Impl;

import beanfactory.BeanFactory;
import dao.ReimburseDao;
import entity.Reimburse;
import exception.ReimburseException;
import service.ReimburseService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReimburseServiceImpl implements ReimburseService {
    private ReimburseDao reimburseDao = (ReimburseDao) BeanFactory.getObject("reimbursedao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public List<Reimburse> listReimburseByUser(int page,String reimName, String reimType, String reimStatus)
            throws ReimburseException{
        try {
            transaction.start();
            List<Reimburse> list  = reimburseDao.listReimburesByUser(page,reimName,reimType,reimStatus);
            if(list != null){
                transaction.commit();
                return list;
            }else {
                throw new ReimburseException("没有此报销单！");
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countReimburseByNames(String reinName) {
        try {
            transaction.start();
            int count = reimburseDao.countReimburseByName(reinName);
            if(count != 0){
                transaction.commit();
                return count;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Reimburse> listReimburseByNames(int page, String reinName) {
        try {
            transaction.start();
            List<Reimburse> list = reimburseDao.listReimburseByName(page,reinName);
            if(list != null){
                transaction.commit();
                return list;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countReimburseByCondition(String reimType, String reimStatus) throws ReimburseException{
        try {
            transaction.start();
            int result = reimburseDao.countReimburseByCondition(reimType,reimStatus);
            if(result != 0){
                transaction.commit();
                return result;
            }else {
                throw new ReimburseException("不在存报销");
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Reimburse> listReimburseByCondition(int page, String reimType, String reimStatus) {
        try {
            transaction.start();
            List<Reimburse> listReimburses = reimburseDao.listReimburseByCondition(page,reimType,reimStatus);
            if(listReimburses != null){
                transaction.commit();
                return listReimburses;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimburse> listReimburseByPage(int page) {
        try {
            transaction.start();
            List<Reimburse> listReimbursePage =  reimburseDao.listReimburseByPage(page);
            if(listReimbursePage != null){
                transaction.commit();
                return  listReimbursePage;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimburse> listReimburse() {
        try {
            transaction.start();
            List<Reimburse> listReimburses = reimburseDao.listReimburse();
            if(listReimburses != null){
                transaction.commit();
                return listReimburses;
            }
        } catch (SQLException e) {
            try {
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
//        ReimburseService reimburseService = new ReimburseServiceImpl();
//        System.out.println(reimburseService.listReimburse().size());
        ReimburseService reimburseService = (ReimburseService)BeanFactory.getObject("reimburseservice");
        System.out.println(reimburseService.countReimburseByNames("som"));
    }
}
