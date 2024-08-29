package com.datacenter.recargas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacenter.recargas.entities.MobileOperator;

/**
 * Repositorio JPA para la tabla/entidad MobileOperator.
 */
public interface MobileOperatorRepository extends JpaRepository<MobileOperator, Integer> {

	/**
	 * Obtiene todo los operadores mobiles.
	 * @return List<MobileOperator> , lista de operadores móviles.
	 */
	public List<MobileOperator> findAllByOrderByMobileOperatorNameAsc();
	
}
