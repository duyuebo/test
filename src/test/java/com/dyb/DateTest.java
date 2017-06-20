package com.dyb;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Unit test for simple App.
 */

public class DateTest {

    @Test
    public void testDateAdd(){
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,12);
        calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(sdf.format(calendar.getTime()));
    }

    @Test
    public void testStringFormat(){
        String message = "您正在绑定手机，验证码：%s，5分钟内有效";
        String val = String.format(message,"12315");
        System.out.println(val);
    }
}
