package com.dyb.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldChineseAnnotation {
    String name();
}