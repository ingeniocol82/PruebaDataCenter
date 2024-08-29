package com.datacenter.dto;

/**
 * DTO que representa la información de un operador móvil.
 */
public class MobileOperatorDTO {
	private Integer mobileOperatorId;
	private String mobileOperatorName;

	public MobileOperatorDTO() {
		super();
	}

	public MobileOperatorDTO(Integer mobileOperatorId, String mobileOperatorName) {
		super();
		this.mobileOperatorId = mobileOperatorId;
		this.mobileOperatorName = mobileOperatorName;
	}

	public Integer getMobileOperatorId() {
		return mobileOperatorId;
	}

	public void setMobileOperatorId(Integer mobileOperatorId) {
		this.mobileOperatorId = mobileOperatorId;
	}

	public String getMobileOperatorName() {
		return mobileOperatorName;
	}

	public void setMobileOperatorName(String mobileOperatorName) {
		this.mobileOperatorName = mobileOperatorName;
	}

	@Override
	public String toString() {
		return "MobileOperatorOutDTO [mobileOperatorId=" + mobileOperatorId + ", mobileOperatorName="
				+ mobileOperatorName + "]";
	}

}
