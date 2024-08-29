package com.datacenter.recargas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacenter.recargas.entities.SalesAgent;

/**
 * Repositorio JPA para la tabla entidad SalesAgent.
 */
public interface SalesAgentRepository extends JpaRepository<SalesAgent, Long> {
	
	/**
	 * Obtiene todos los agentes de ventas registrados.
	 * @return List<SalesAgent> Agentes de ventas.
	 */
	public List<SalesAgent> findAllByOrderBySalesAgentFullNameAsc();
	
}
