package com.datacenter.recargas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datacenter.recargas.dto.MobileOperatorOutDTO;
import com.datacenter.recargas.dto.MobileOperatorOutDTOMapper;
import com.datacenter.recargas.entities.MobileOperator;
import com.datacenter.recargas.repositories.MobileOperatorRepository;

/**
 * Servicio business encargado de la lógica de los operadores móviles.
 */
@Service
public class MobileOperatorService {
	/** Referencia a repositorio de operadores móviles. */
	@Autowired
	private MobileOperatorRepository mobileOperatorRepository;
	
	/**
	 * Obtiene la lista de todos los operadores móviles.
	 * @return List<MobileOperatorOutDTO> lista de operadores.
	 */
	public List<MobileOperatorOutDTO> getAllMobileOperators() {
		List<MobileOperator> operators = mobileOperatorRepository.findAllByOrderByMobileOperatorNameAsc();
		
		List<MobileOperatorOutDTO> operatorsListOutDTO = 
				MobileOperatorOutDTOMapper.INSTANCE.mobilerOperatorListToListOutDTO(operators);
		
		return operatorsListOutDTO;
		
	}

}
