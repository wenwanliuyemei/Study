package com.xm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangxiumei on 2017/6/1.
 */

public class Time {

    public static String getTime(){
        StringBuffer stringBuffer=new StringBuffer();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        stringBuffer.append(simpleDateFormat.format(date));
        return stringBuffer.toString();
    }
}
