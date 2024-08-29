package com.datacenter.recargas.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Objeto que encapsula la información de un operador móvil.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MobileOperatorOutDTO {
	private Integer mobileOperatorId;
	private String mobileOperatorName;
}
