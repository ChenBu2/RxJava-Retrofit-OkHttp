package cn.com.san.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * date: Created hongchen on 16/11/05.
 */
public class TimeUtil {

    public static String formatTZ(String tzDataStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date date = format.parse(tzDataStr);
            format = new SimpleDateFormat("yyyy.MM.dd");
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formatTime(String formatTime){
        Date result_date;
        String s = "";
        long result_time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        SimpleDateFormat dspFmt = new SimpleDateFormat("yyyy-MM-dd");
        try { // 将输入时间字串转换为UTC时间
            sdf.setTimeZone(TimeZone.getTimeZone("GMT00:00"));
            result_date = sdf.parse(formatTime);
            result_time = result_date.getTime();
        } catch (Exception e) { // 出现异常时，使用本地时间

        }
        // 设定时区
        s = dspFmt.format(result_time);
        return s;
    }

    public static String getNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    public static Long getTimeDate() {
        return new Date().getTime() / 1000;// new Date()为获取当前系统时间
    }
}
