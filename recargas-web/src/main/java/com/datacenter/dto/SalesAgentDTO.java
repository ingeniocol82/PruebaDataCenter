package com.datacenter.dto;

/**
 * DTO que representa la información de un agente de ventas.
 */
public class SalesAgentDTO {
	private Long salesAgentCode;
	private String salesAgentFullName;

	public SalesAgentDTO() {
		super();
	}

	public SalesAgentDTO(Long salesAgentCode, String salesAgentFullName) {
		super();
		this.salesAgentCode = salesAgentCode;
		this.salesAgentFullName = salesAgentFullName;
	}

	public Long getSalesAgentCode() {
		return salesAgentCode;
	}

	public void setSalesAgentCode(Long salesAgentCode) {
		this.salesAgentCode = salesAgentCode;
	}

	public String getSalesAgentFullName() {
		return salesAgentFullName;
	}

	public void setSalesAgentFullName(String salesAgentFullName) {
		this.salesAgentFullName = salesAgentFullName;
	}

	@Override
	public String toString() {
		return "SalesAgentOutDTO [salesAgentCode=" + salesAgentCode + ", salesAgentFullName=" + salesAgentFullName
				+ "]";
	}
}
