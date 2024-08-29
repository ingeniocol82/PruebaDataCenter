package com.datacenter.dto;

import java.math.BigDecimal;

/**
 * DTO que representa la información una recarga.
 */
public class SaveRechargeInDTO {
	private String rechargeMobileNumber;
	private BigDecimal rechargeAmount;
	private Integer mobileOperatorId;
	private Long salesAgentCode;

	public SaveRechargeInDTO() {
		super();
	}

	public SaveRechargeInDTO(String rechargeMobileNumber, BigDecimal rechargeAmount, Integer mobileOperatorId,
			Long salesAgentCode) {
		super();
		this.rechargeMobileNumber = rechargeMobileNumber;
		this.rechargeAmount = rechargeAmount;
		this.mobileOperatorId = mobileOperatorId;
		this.salesAgentCode = salesAgentCode;
	}

	public String getRechargeMobileNumber() {
		return rechargeMobileNumber;
	}

	public void setRechargeMobileNumber(String rechargeMobileNumber) {
		this.rechargeMobileNumber = rechargeMobileNumber;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Integer getMobileOperatorId() {
		return mobileOperatorId;
	}

	public void setMobileOperatorId(Integer mobileOperatorId) {
		this.mobileOperatorId = mobileOperatorId;
	}

	public Long getSalesAgentCode() {
		return salesAgentCode;
	}

	public void setSalesAgentCode(Long salesAgentCode) {
		this.salesAgentCode = salesAgentCode;
	}

	@Override
	public String toString() {
		return "SaveRechargeInDTO [rechargeMobileNumber=" + rechargeMobileNumber + ", rechargeAmount=" + rechargeAmount
				+ ", mobileOperatorId=" + mobileOperatorId + ", salesAgentCode=" + salesAgentCode + "]";
	}

}
