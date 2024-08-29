package com.datacenter.recargas.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.datacenter.recargas.entities.Recharge;

/**
 * Mapeador que convierte un objeto del tipo Recharge a SaveRechargeOutDTO.
 */
@Mapper
public interface SaveRechargeOutDTOMapper {
 
	SaveRechargeOutDTOMapper INSTANCE = Mappers.getMapper( SaveRechargeOutDTOMapper.class );
 
	@Mapping(target = "rechargeId", source = "rechargeId")
    @Mapping(target = "rechargeCreationDateTime", source = "rechargeCreationDateTime")
    SaveRechargeOutDTO rechargeToSaveRechargeOutDTO(Recharge savedRecharge);
}