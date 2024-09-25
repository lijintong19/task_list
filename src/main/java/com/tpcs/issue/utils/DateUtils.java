package com.tpcs.issue.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 获取新的时间点，当前时间点加12小时,部署服务器的时间和现实时间相差12小时
     * 
     * @return
     */
    public static Date getDatePlus12Hours() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 12);
        return calendar.getTime();
    }
}
