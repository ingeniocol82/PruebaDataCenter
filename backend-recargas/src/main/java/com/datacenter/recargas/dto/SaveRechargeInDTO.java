package com.datacenter.recargas.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto que encapsula la información de entrada para una recarga.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SaveRechargeInDTO {
	private String rechargeMobileNumber;
	private BigDecimal rechargeAmount;
	private Integer mobileOperatorId;
	private Long salesAgentCode;
}
