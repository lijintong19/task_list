package com.tpcs.issue.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取新的时间点，当前时间点加8小时
     * 
     * @return
     */
    public static Date getDatePlus12Hours() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 12);
        return calendar.getTime();
    }
}
