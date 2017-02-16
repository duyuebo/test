package com.dyb;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {

    @Test
    public void testSubString(){
        String code = "331022199002049307";
        String birthDay = code.substring(6, 10) + "-" + code.substring(10, 12) + "-" + code.substring(12, 14);
        System.out.println(birthDay);

        String sexStr = code.substring(code.length()-2,code.length()-1);
        int a = Integer.parseInt(sexStr)%2;
        System.out.println(a);
    }

    @Test
    public void testStringFormat(){
        String message = "您正在绑定手机，验证码：%s，5分钟内有效";
        String val = String.format(message,"12315");
        System.out.println(val);
    }
}
