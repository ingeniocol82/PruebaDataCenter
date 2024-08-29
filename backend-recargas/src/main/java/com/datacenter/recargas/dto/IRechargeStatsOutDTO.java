package com.datacenter.recargas.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Proyección que instancia spring para obtener los datos de
 * estadísticas de ventas por operador y vendedor.
 */
@JsonInclude(Include.NON_NULL)
public interface IRechargeStatsOutDTO {

	public String getMobileOperatorName();

	public Integer getRechargeCount();

	public BigDecimal getTotalRechargeValue();

	public String getSalesAgentFullName();
}
