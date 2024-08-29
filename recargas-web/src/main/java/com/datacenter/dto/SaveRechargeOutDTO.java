package com.datacenter.dto;

/**
 * DTO que representa la información de respuesta de una recarga.
 */
public class SaveRechargeOutDTO {
	private Long rechargeId;
	private String rechargeCreationDateTime;

	public SaveRechargeOutDTO() {
		super();
	}

	public SaveRechargeOutDTO(Long rechargeId, String rechargeCreationDateTime) {
		super();
		this.rechargeId = rechargeId;
		this.rechargeCreationDateTime = rechargeCreationDateTime;
	}

	public Long getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}

	public String getRechargeCreationDateTime() {
		return rechargeCreationDateTime;
	}

	public void setRechargeCreationDateTime(String rechargeCreationDateTime) {
		this.rechargeCreationDateTime = rechargeCreationDateTime;
	}

	@Override
	public String toString() {
		return "SaveRechargeOutDTO [rechargeId=" + rechargeId + ", rechargeCreationDateTime=" + rechargeCreationDateTime
				+ "]";
	}
}
