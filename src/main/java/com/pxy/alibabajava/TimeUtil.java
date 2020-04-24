package com.pxy.alibabajava;

import java.time.Instant;
import java.util.Calendar;

/**
 * @author pengxueyin
 */
public class TimeUtil {
    private boolean isSuccess = false;

    public static void main(String[] args) {
        //在JDK8中，针对统计时间等场景，推荐使用Instant类
        System.out.println(Instant.now());
        //使用枚举值代替月份的数字
        System.out.println(Calendar.JANUARY);
        //不允许在程序中使用java.sql.Date和java.sql.Time。前者不记录时间，getHours()抛出异常。后者不记录日期，getYear()抛出异常。
        new java.sql.Date(System.currentTimeMillis()).getHours();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
