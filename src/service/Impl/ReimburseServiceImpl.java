package service.Impl;

import beanfactory.BeanFactory;
import dao.ReimburseDao;
import entity.Reimburse;
import service.ReimburseService;
import util.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReimburseServiceImpl implements ReimburseService {
    private ReimburseDao reimburseDao = (ReimburseDao) BeanFactory.getObject("reimbursedao");
    private Transaction transaction = (Transaction) BeanFactory.getObject("transaction");

    @Override
    public int countReimburseByCondition(String reimType, String reimStatus) {
        try {
            transaction.start();
            int result = reimburseDao.countReimburseByCondition(reimType,reimStatus);
            if(result != 0){
                transaction.commit();
                return result;
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
        System.out.println(reimburseService.countReimburseByCondition("clf","3"));
    }
}
