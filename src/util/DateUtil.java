package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {
    /**
     * 获取当前日期(Date类型)
     * @return
     */
    public static Date getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentTime = sdf.format(date);
        try {
            return sdf.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前的时间(String 类型)
     * @return
     */
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return sdf.format(date);
    }


    /**
     * 将日期转换为字符串
     * @param date
     * @return
     */
   public static String dateToString(Date date){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String str = sdf.format(date);
       return  str;
   }

    /**
     * 将字符串转换为日期
     * @param str
     * @return
     */
   public static Date stringToDate(String str){
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date date = null;
       try {
           date = sdf.parse(str);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return date;
   }
}
