package com.datacenter.recargas.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.datacenter.recargas.entities.MobileOperator;

/**
 * Mapeador que convierte un objeto del tipo List<MobileOperator> salesAgentList a 
 * List<MobileOperatorOutDTO>.
 */
@Mapper
public interface MobileOperatorOutDTOMapper {
	
	MobileOperatorOutDTOMapper INSTANCE = Mappers.getMapper(MobileOperatorOutDTOMapper.class);

	List<MobileOperatorOutDTO> mobilerOperatorListToListOutDTO(List<MobileOperator> mobileOperatorList);
}
