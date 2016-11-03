package com.dyb; /**
 * LY.com Inc.
 * Copyright (c) 2004-${year} All Rights Reserved.
 */

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付回写详情实体
 * 
 * @author hw24221
 * @version $Id: TradeDetail.java, v 0.1 2016年7月21日 上午10:31:02 hw24221 Exp $
 */
public class TradeDetail {

	private String TcSerialId; // 公共支付交易流水
	private String MerSerialId; // 支付平台交易流水
	private String OutSerialid; // 支付唯一号
	private BigDecimal Amount; // 支付金额
	private int ProductId; // 支付方式枚举
	private Date PayFinishTime; // 支付成功实间
	private String OpenId; // 微信openid
	private int BankType; // 银行类型
	private String BankName; // 银行名称
	private String ReceveCompany; // 收款公司
	private BigDecimal ReduceAmount; // 立减金额
	private BigDecimal AwardAmount; // 立返金额
	private String Operator; //操作人

	public String getTcSerialId() {
		return TcSerialId;
	}

	public void setTcSerialId(String tcSerialId) {
		TcSerialId = tcSerialId;
	}

	public String getMerSerialId() {
		return MerSerialId;
	}

	public void setMerSerialId(String merSerialId) {
		MerSerialId = merSerialId;
	}

	public String getOutSerialid() {
		return OutSerialid;
	}

	public void setOutSerialid(String outSerialid) {
		OutSerialid = outSerialid;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public Date getPayFinishTime() {
		return PayFinishTime;
	}

	public void setPayFinishTime(Date payFinishTime) {
		PayFinishTime = payFinishTime;
	}

	public String getOpenId() {
		return OpenId;
	}

	public void setOpenId(String openId) {
		OpenId = openId;
	}

	public int getBankType() {
		return BankType;
	}

	public void setBankType(int bankType) {
		BankType = bankType;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getReceveCompany() {
		return ReceveCompany;
	}

	public void setReceveCompany(String receveCompany) {
		ReceveCompany = receveCompany;
	}

	public BigDecimal getReduceAmount() {
		return ReduceAmount;
	}

	public void setReduceAmount(BigDecimal reduceAmount) {
		ReduceAmount = reduceAmount;
	}

	public BigDecimal getAwardAmount() {
		return AwardAmount;
	}

	public void setAwardAmount(BigDecimal awardAmount) {
		AwardAmount = awardAmount;
	}
	
	public String getOperator(){
		return this.Operator;
	}
	
	public void setOperator(String operator){
		this.Operator = operator;
	}

}
