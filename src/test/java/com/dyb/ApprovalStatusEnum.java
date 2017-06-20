/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;

/**
 * 审批状态枚举
 * @author mwh37173
 * @version $Id: ApprovalStatusEnum.java, v 0.1 2016年9月30日 下午2:19:28 mwh37173 Exp $
 */
public enum ApprovalStatusEnum {
    /** 待审批 */
    WAITAPPROVAL(1, "WAITAPPROVAL"),
    /** 审批中*/
    APPROVALING(2, "APPROVALING"),
    /** 审批通过*/
    PASSAPPROVAL(3, "PASSAPPROVAL"),
    /** 审批否决*/
    VETOAPPROVAL(4, "VETOAPPROVAL"),
    /** 撤销审批*/
    UNDOAPPROVAL(5, "UNDOAPPROVAL");
    /** 键 */
    private int    key;
    /** 值 */
    private String value;

    /**
     * Getter method for property <tt>key</tt>.
     * 
     * @return property value of key
     */
    public int getKey() {
        return key;
    }

    /**
     * Setter method for property <tt>key</tt>.
     * 
     * @param key value to be assigned to property key
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Getter method for property <tt>value</tt>.
     * 
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter method for property <tt>value</tt>.
     * 
     * @param value value to be assigned to property value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * 构造函数
     * @param key
     * @param value
     */
    private ApprovalStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
