package com.datacenter.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.datacenter.client.BackendClient;
import com.datacenter.dto.MobileOperatorDTO;
import com.datacenter.dto.SalesAgentDTO;
import com.datacenter.dto.SaveRechargeInDTO;
import com.datacenter.dto.SaveRechargeOutDTO;

/**
 * Backing bean encargado del manejo de la página de registro de recargas.
 */
@Named("recargasBean")
@ViewScoped
public class RecargasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Número de celular en el formulario. */
	private String mobileNumber;
	/** Valor de recarga en el formulario. */
	private String rechargeAmount;
	/** Código operador móvil en el formulario. */
	private Integer mobileOperator;
	/** Código de agente de ventas en el formulario. */
	private Long salesAgent;

	/** Almacena la lista de operadores obtenida por API. */
	private List<MobileOperatorDTO> mobileOperatorList;
	/** Almacena la lista de agentes obtenida por API. */
	private List<SalesAgentDTO> salesAgenteList;

	/** Referencia a cliente de la API Spring boot.*/
	private BackendClient backClient;

	/**
	 * Método de inicialización de la pantalla, que invoca apis para consultar 
	 * información.
	 */
	@PostConstruct
	public void init() {
		backClient = new BackendClient();
		mobileOperatorList = backClient.getAllMobileOperators();
		salesAgenteList = backClient.getAllSalesAgents();
	}

	/**
	 * Action que se ejecuta y permite el registro de una recarga
	 * llamando a la api spring boot.
	 */
	public void realizarRecarga() {
		try {
			SaveRechargeInDTO saveRechargeInDTO = new SaveRechargeInDTO();
			saveRechargeInDTO.setRechargeMobileNumber(mobileNumber);
			saveRechargeInDTO.setRechargeAmount(new BigDecimal(rechargeAmount));
			saveRechargeInDTO.setMobileOperatorId(mobileOperator);
			saveRechargeInDTO.setSalesAgentCode(salesAgent);

			System.out.println("Recarga a agregar: " + saveRechargeInDTO);

			SaveRechargeOutDTO saveRechargeOutDTO = backClient.saveRecharge(saveRechargeInDTO);

			System.out.println("Información Retornada: " + saveRechargeOutDTO);

			String mensajeExito = "Recarga creada con exito, Número: " + saveRechargeOutDTO.getRechargeId();
			resetForm();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensajeExito));
		} catch (Exception e) {
			// Mensaje de error de la recarga
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error En Registro de Recarga", e.getMessage()));
		}
	}

	/**
	 * Limpia los campos del formulario luego de una recarga.
	 */
	private void resetForm() {
		this.mobileNumber = null;
		this.rechargeAmount = null;
		this.mobileOperator = null;
		this.salesAgent = null;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(String rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public Integer getMobileOperator() {
		return mobileOperator;
	}

	public void setMobileOperator(Integer mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public Long getSalesAgent() {
		return salesAgent;
	}

	public void setSalesAgent(Long salesAgent) {
		this.salesAgent = salesAgent;
	}

	public List<MobileOperatorDTO> getMobileOperatorList() {
		return mobileOperatorList;
	}

	public void setMobileOperatorList(List<MobileOperatorDTO> mobileOperatorList) {
		this.mobileOperatorList = mobileOperatorList;
	}

	public List<SalesAgentDTO> getSalesAgenteList() {
		return salesAgenteList;
	}

	public void setSalesAgenteList(List<SalesAgentDTO> salesAgenteList) {
		this.salesAgenteList = salesAgenteList;
	}

}
