package com.datacenter.recargas.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.datacenter.recargas.entities.MobileOperator;
import com.datacenter.recargas.entities.SalesAgent;

/**
 * Mapeador que convierte un objeto del tipo List<SalesAgent> salesAgentList a 
 * List<SalesAgentOutDTO>.
 */
@Mapper
public interface SalesAgentOutDTOMapper {
	
	SalesAgentOutDTOMapper INSTANCE = Mappers.getMapper(SalesAgentOutDTOMapper.class);

	List<SalesAgentOutDTO> salesAgentListToListOutDTO(List<SalesAgent> salesAgentList);
}
