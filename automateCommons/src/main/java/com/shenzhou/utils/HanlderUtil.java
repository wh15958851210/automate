package com.shenzhou.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HanlderUtil {
    // 转换 若为null 转换为 ""
    public static String changeType(String s){
        if(s==null){
            return "";
        }else{
            return s;
        }
    }

    // 转换时间戳
    public static String changeTime(String data){
        if("".equals(data)||data==null){
            return data;
        }else{
            return timedate(data);
        }
    }

    // 将时间戳转换  格式
    public static String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    // 现在日期
    public static String nowTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        return nowTime;
    }
}
