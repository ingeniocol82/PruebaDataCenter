package com.datacenter.recargas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.recargas.dto.IRechargeStatsOutDTO;
import com.datacenter.recargas.dto.MobileOperatorOutDTO;
import com.datacenter.recargas.dto.SalesAgentOutDTO;
import com.datacenter.recargas.dto.SaveRechargeInDTO;
import com.datacenter.recargas.dto.SaveRechargeOutDTO;
import com.datacenter.recargas.services.MobileOperatorService;
import com.datacenter.recargas.services.RechargeService;
import com.datacenter.recargas.services.SalesAgentService;

/**
 * Servicio rest que expone la API de recargas.
 */
@RestController
@RequestMapping("/api/recharge")
public class RechargeController {
    /** Lógica de negocio de recargas. */
	@Autowired
	private RechargeService rechargeService;
	/** Lógica de negocio de operadores móviles. */
	@Autowired
	private MobileOperatorService mobileOperatorService;
	/** Lógica de negocio de agentes de ventas. */
	@Autowired
	private SalesAgentService salesAgentService;
	
	/**
	 * Operación de la API encargada de registrar una recarga.
	 * @param recharge información de la recarga.
	 * @return respuesta a la recarga.
	 */
	@PostMapping("/add")
	public ResponseEntity<SaveRechargeOutDTO> saveRecharge(@RequestBody SaveRechargeInDTO recharge) {
		SaveRechargeOutDTO rechargeSavedToDB = this.rechargeService.saveMobileRecharge(recharge);
        return new ResponseEntity<SaveRechargeOutDTO>(rechargeSavedToDB, HttpStatus.CREATED);
    }
	
	/**
	 * Operación que obtiene las estadísticas por operador móvil.
	 * @return Lista de estadísticas.
	 */
	@GetMapping("/stats/byMobileOp")
	public ResponseEntity<List<IRechargeStatsOutDTO>> saleStatsByMobileOperator() {
		List<IRechargeStatsOutDTO> rechargeStatsList =  this.rechargeService.saleStatsByMobileOperator();
		return new ResponseEntity<List<IRechargeStatsOutDTO>>(rechargeStatsList, HttpStatus.OK);
	}
	
	/**
	 * Operación que obtiene las estadísticas por agente de ventas.
	 * @return lista de estadísticas agentes de ventas.
	 */
	@GetMapping("/stats/bySalesAgent")
	public ResponseEntity<List<IRechargeStatsOutDTO>> saleStatsBySalesAgent() {
		List<IRechargeStatsOutDTO> rechargeStatsList =  this.rechargeService.saleStatsBySalesAgent();
		return new ResponseEntity<List<IRechargeStatsOutDTO>>(rechargeStatsList, HttpStatus.OK);
	}
	
	/**
	 * Operación que obtiene la lista de operadores móviles.
	 * @return lista de operadores móviles.
	 */
	@GetMapping("/operators/list")
	public ResponseEntity<List<MobileOperatorOutDTO>> getAllMobileOperators() {
		List<MobileOperatorOutDTO> mobileOperatorsList =  this.mobileOperatorService.getAllMobileOperators();
		return new ResponseEntity<List<MobileOperatorOutDTO>>(mobileOperatorsList, HttpStatus.OK);
	}
	
	/**
	 * Operación que obtiene la lista de agentes de ventas.
	 * @return lista de agentes de ventas.
	 */
	@GetMapping("/agents/list")
	public ResponseEntity<List<SalesAgentOutDTO>> getAllSalesAgents() {
		List<SalesAgentOutDTO> salesAgentList =  this.salesAgentService.getAllSalesAgents();
		return new ResponseEntity<List<SalesAgentOutDTO>>(salesAgentList, HttpStatus.OK);
	}
	
}
