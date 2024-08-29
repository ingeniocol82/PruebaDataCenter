package com.datacenter.recargas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.recargas.dto.IRechargeStatsOutDTO;
import com.datacenter.recargas.dto.SaveRechargeInDTO;
import com.datacenter.recargas.dto.SaveRechargeInDTOMapper;
import com.datacenter.recargas.dto.SaveRechargeOutDTOMapper;
import com.datacenter.recargas.dto.SaveRechargeOutDTO;
import com.datacenter.recargas.entities.Recharge;
import com.datacenter.recargas.repositories.RechargeRepository;

/**
 * Servicio busines encargado de la lógica de las recargas.
 */
@Service
public class RechargeService {
	/** Referencia al repositorio JPA de recarga. */
	@Autowired
	private RechargeRepository rechargeRepository;

	/**
	 * Regista en persistencia una recarga solicitada.
	 * @param saveRechargeInDTO información de la recarga solicitada.
	 * @return Respuesta a la operación.
	 */
	@Transactional
	public SaveRechargeOutDTO saveMobileRecharge(SaveRechargeInDTO saveRechargeInDTO) {
		
		Recharge newRecharge = SaveRechargeInDTOMapper.INSTANCE.saveRechargeInDTOToRecharge(saveRechargeInDTO);
		Recharge rechargeSaved = rechargeRepository.saveAndFlush(newRecharge);
		SaveRechargeOutDTO saveRechargeOutDTO = 
				SaveRechargeOutDTOMapper.INSTANCE.rechargeToSaveRechargeOutDTO(rechargeSaved);

		return saveRechargeOutDTO;
	}

	/**
	 * Obtiene las estadísticas de ventas por operador móvil.
	 * @return List<IRechargeStatsOutDTO> Estadísticas de operador.
	 */
	public List<IRechargeStatsOutDTO> saleStatsByMobileOperator() {

		return rechargeRepository.saleStatsByMobileOperator();
	}
	
	/**
	 * Obtiene las estadísticas de ventas por agente de ventas.
	 * @return List<IRechargeStatsOutDTO> Estadísticas de agente de ventas.
	 */
	public List<IRechargeStatsOutDTO> saleStatsBySalesAgent() {

		return rechargeRepository.saleStatsBySalesAgent();
	}

}
