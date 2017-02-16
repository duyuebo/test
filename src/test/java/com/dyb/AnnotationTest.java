/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;
import org.junit.Test;
/**
 *
 * @author dyb37716
 * @version $Id: AnnotationTest, v 0.1 2016/11/9 10:25 dyb37716 Exp $
 */
public class AnnotationTest {

    @Test
    public void test(){
        Long a = 1l;
        Long b = new Long(1);

        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
