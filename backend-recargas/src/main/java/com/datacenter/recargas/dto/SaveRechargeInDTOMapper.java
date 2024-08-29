package com.datacenter.recargas.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.datacenter.recargas.entities.Recharge;

/**
 * Mapeador que convierte un objeto del tipo SaveRechargeInDTO a Recharge.
 */
@Mapper
public interface SaveRechargeInDTOMapper {
	
	SaveRechargeInDTOMapper INSTANCE = Mappers.getMapper( SaveRechargeInDTOMapper.class );
	
	@Mapping(target = "rechargeMobileNumber", source = "rechargeMobileNumber")
	@Mapping(target = "rechargeAmount", source = "rechargeAmount")
	@Mapping(target = "rechargeMobileOperator.mobileOperatorId", source = "mobileOperatorId")
	@Mapping(target = "rechargeSalesAgent.salesAgentCode", source = "salesAgentCode")
	Recharge saveRechargeInDTOToRecharge(SaveRechargeInDTO savedRechargeInDTO);

}
