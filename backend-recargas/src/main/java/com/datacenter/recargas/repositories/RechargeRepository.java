package com.datacenter.recargas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.datacenter.recargas.dto.IRechargeStatsOutDTO;
import com.datacenter.recargas.entities.Recharge;

/**
 * Repositorio JPA para la tabla entidad Recarga.
 */
public interface RechargeRepository  extends JpaRepository<Recharge, Long> {

	/**
	 * Consulta las cifras de ventas por operador móvil.
	 * @return List<IRechargeStatsOutDTO> lista de estadísticas.
	 */
	@Query("Select r.rechargeMobileOperator.mobileOperatorName AS mobileOperatorName, "
			+ "count(r.rechargeId) AS rechargeCount, "
			+ "sum(r.rechargeAmount) AS totalRechargeValue "
			+ "FROM Recharge r "
			+ "GROUP BY r.rechargeMobileOperator.mobileOperatorId "
			+ "ORDER BY r.rechargeMobileOperator.mobileOperatorName")
	public List<IRechargeStatsOutDTO> saleStatsByMobileOperator();
	
	/**
	 * Consulta las cifras de ventas por agente de ventas.
	 * @return List<IRechargeStatsOutDTO> lista de estadísticas.
	 */
	@Query("Select r.rechargeSalesAgent.salesAgentFullName AS salesAgentFullName, "
			+ "r.rechargeMobileOperator.mobileOperatorName AS mobileOperatorName, "
			+ "count(r.rechargeId) AS rechargeCount, "
			+ "sum(r.rechargeAmount) AS totalRechargeValue "
			+ "FROM Recharge r "
			+ "GROUP BY r.rechargeSalesAgent.salesAgentCode , r.rechargeMobileOperator.mobileOperatorId "
			+ "ORDER BY r.rechargeSalesAgent.salesAgentFullName, r.rechargeMobileOperator.mobileOperatorName")
	public List<IRechargeStatsOutDTO> saleStatsBySalesAgent();
}
