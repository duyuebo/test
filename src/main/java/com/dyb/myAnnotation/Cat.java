/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb.myAnnotation;

import java.io.Serializable;

/**
 *
 * @author dyb37716
 * @version $Id: Cat, v 0.1 2016/11/9 13:33 dyb37716 Exp $
 */
public class Cat implements Serializable {
    @FieldChineseAnnotation(name = "名称")
    private String name;
    @FieldChineseAnnotation(name = "年龄")
    private Integer age;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
