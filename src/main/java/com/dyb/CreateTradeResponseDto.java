/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.dyb;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 创建交易请求返回类
 * @author hw24221
 * @version $Id: CreateTradeResponseDto.java, v 0.1 2016年8月22日 下午1:19:45 hw24221 Exp $
 */
public class CreateTradeResponseDto {

    /**
     * 错误返回码，成功则返回0
     */
    @JSONField(name = "ErrorCode")
    private int                  errorCode;

    /**
     * 失败原因
     */
    @JSONField(name = "ErrorMessage")
    private String               errorMessage;

    /**
     * 支付链接
     */
    @JSONField(name = "PayUrl")
    private String               payUrl;

    /**
     * 支付唯一码详情
     */
    @JSONField(name = "TradeDetailList")
    private List<TradeDetailDto> tradeDetailList;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public List<TradeDetailDto> getTradeDetailList() {
        return tradeDetailList;
    }

    public void setTradeDetailList(List<TradeDetailDto> tradeDetailList) {
        this.tradeDetailList = tradeDetailList;
    }

}
