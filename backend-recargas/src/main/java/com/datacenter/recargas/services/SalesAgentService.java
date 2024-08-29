package com.datacenter.recargas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datacenter.recargas.dto.SalesAgentOutDTO;
import com.datacenter.recargas.dto.SalesAgentOutDTOMapper;
import com.datacenter.recargas.entities.SalesAgent;
import com.datacenter.recargas.repositories.SalesAgentRepository;

/**
 * Servicio business encargado de la lógica relacionada con la entidad SalesAgent.
 */
@Service
public class SalesAgentService {
	/** Referencia al repositorio de la entidad*/
	@Autowired
	private SalesAgentRepository salesAgentRepository;
	
	/**
	 * Obtiene todos los agentes de ventas registrados.
	 * @return List<SalesAgentOutDTO> lista de agentes de ventas.
	 */
	public List<SalesAgentOutDTO> getAllSalesAgents() {
		List<SalesAgent> salesAgentList = salesAgentRepository.findAllByOrderBySalesAgentFullNameAsc();
		
		List<SalesAgentOutDTO> salesAgentListOutDTO = 
				SalesAgentOutDTOMapper.INSTANCE.salesAgentListToListOutDTO(salesAgentList);
		
		return salesAgentListOutDTO;
		
	}

}
