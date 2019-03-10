package util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil {

    static Properties prop = new Properties();
    static DataSource ds = null;
    static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static{
        try{
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    /**
     * 数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = threadLocal.get();
            if(conn == null){
                conn = ds.getConnection();
                threadLocal.set(conn);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 执行insert delete update
     * @return
     */
    public static  int update(String sql, Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        conn = JDBCUtil.getConnection();
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            JDBCUtil.releaseDB(conn,ps,null);
        }
        return result;
    }

    /**
     * 数据库查询多条记录
     */
    public static List<Object> executeQuery(String sql , RowMapperObject rmo ,Object ... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> list = null;
        try{
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                Object obj = rmo.rowMapperObject(rs);
                list.add(obj);
            }
            if(list.size() == 0){
                return  null;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
//            JDBCUtil.releaseDB(conn,ps,rs);

        }
        return list;
    }



    /**
     * 关闭数据库
     * @param conn
     * @param ps
     * @param rs
     */
    public static void releaseDB(Connection conn, PreparedStatement ps , ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }






    public static void main(String [] args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM dept";
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                String a = rs.getString("dept_name");
                System.out.println(a);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.releaseDB(conn,ps,rs);
        }


    }
    

}
