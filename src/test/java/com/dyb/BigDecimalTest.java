/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.dyb;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author dyb37716
 * @version $Id: BigDecimalTest, v 0.1 2017/3/2 10:20 dyb37716 Exp $
 */
public class BigDecimalTest {

    @Test
    public void formatTest(){
        String value = "2.000000";

        DecimalFormat df = new DecimalFormat("0.#");
        System.out.println(df.format(new BigDecimal(value)));
    }

    @Test
    public void subStringTest(){
        String value = "yuebo/du";
        System.out.println(value.substring(0,value.indexOf("/")).trim());
        System.out.println(value.substring(value.indexOf("/")+1).trim());

        System.out.println(ApprovalStatusEnum.APPROVALING.getKey());
    }

    @Test
    public void testBigDecimal(){
        BigDecimal a = new BigDecimal("2");
        System.out.println(add(a));
        System.out.println(a);
    }

    private BigDecimal add(BigDecimal a){
        a = a.add(new BigDecimal("3"));
        return a;
    }
}
