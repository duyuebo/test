package com.dyb; /**
 * LY.com Inc.
 * Copyright (c) 2004-${year} All Rights Reserved.
 */

import java.util.List;

/**
 * 支付回写参数实体
 * 
 * @author hw24221
 * @version $Id: TradeNoticeDomain.java, v 0.1 2016年7月21日 上午10:31:12 hw24221 Exp $
 */
public class TradeNoticeDomain {

	private String OrderGuid; // 订单号
	private List<TradeDetail> TradeDetailList; // 订单详情

	public String getOrderGuid() {
		return OrderGuid;
	}

	public void setOrderGuid(String orderGuid) {
		OrderGuid = orderGuid;
	}

	public List<TradeDetail> getTradeDetailList() {
		return TradeDetailList;
	}

	public void setTradeDetailList(List<TradeDetail> tradeDetailList) {
		TradeDetailList = tradeDetailList;
	}

}
