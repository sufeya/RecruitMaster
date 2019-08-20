package com.lwc.util;

import com.lwc.constrant.Constrant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constrant.DATE_FORMAT);
    //将字符串转化为日期
    public static String dateToString(Date date){
        return simpleDateFormat.format(date);
    }
    //将字符串转化为日期
    public static Date stringToDate(String date){
        Date date1=null;
        try {
            date1=simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}
