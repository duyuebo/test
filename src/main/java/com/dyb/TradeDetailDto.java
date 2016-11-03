/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 支付唯一码详情类
 * @author hw24221
 * @version $Id: TradeDetailDto.java, v 0.1 2016年8月22日 下午1:24:35 hw24221 Exp $
 */
public class TradeDetailDto {

    /**
     * 支付唯一码
     */
    @JSONField(name = "TradeNo")
    private String tradeNo;

    /**
     * 收款公司
     */
    @JSONField(name = "ReceviceCompany")
    private String receviceCompany;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getReceviceCompany() {
        return receviceCompany;
    }

    public void setReceviceCompany(String receviceCompany) {
        this.receviceCompany = receviceCompany;
    }

}
