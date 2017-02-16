/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author dyb37716
 * @version $Id: ThreadLocalTest, v 0.1 2016/11/26 16:44 dyb37716 Exp $
 */
public class ThreadLocalTest {

    private static AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    @Test
    public void testAtomicInteger(){
        for (int i = 0; i < 20; i++) {
            //System.out.println(nextHashCode);
            int b = nextHashCode.getAndAdd(0x61c88647);
            int k = b & 12;
            System.out.println(i + "," + nextHashCode + "," + b + "," + k);
        }

    }

    @Test
    public void testBigDecimal(){
        BigDecimal decimal = new BigDecimal(0);
        System.out.println(decimal.equals(new BigDecimal(0)));
        Assert.assertEquals(decimal,new BigDecimal(0));
        decimal = new BigDecimal("0.5");
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(decimal));
        BigDecimal decimal1 = new BigDecimal("0.00");
        BigDecimal decimal2 = new BigDecimal("0");
        System.out.println(decimal1.compareTo(decimal2));
        System.out.println(decimal1.equals(decimal2));
    }
}
