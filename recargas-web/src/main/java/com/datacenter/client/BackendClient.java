package com.datacenter.client;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.datacenter.dto.MobileOperatorDTO;
import com.datacenter.dto.SalesAgentDTO;
import com.datacenter.dto.SaveRechargeInDTO;
import com.datacenter.dto.SaveRechargeOutDTO;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Implementación de cliente de API Rest Spring Boot, usando la librería jersey client.
 */
public class BackendClient {
	
	private final static String URL_BASE_API = "http://localhost:9000/api/recharge";
	
	private final static String SAVE_RECHARGE = "/add";
	
	private final static String GET_ALL_MOBILE_OPERATORS = "/operators/list";
	
	private final static String GET_ALL_SALES_AGENTS = "/agents/list";
	
	/**
	 * Llamado a operación de consulta de todos los operadores.
	 * @return lista de operadores obtenidos.
	 */
	public List<MobileOperatorDTO> getAllMobileOperators() {
		Client client = ClientBuilder.newClient(
	            new ClientConfig().register(JacksonJsonProvider.class));
	    WebTarget webTarget = client.target(URL_BASE_API).path(GET_ALL_MOBILE_OPERATORS);
		
	    Response response = webTarget
	            .request(MediaType.APPLICATION_JSON_TYPE)
	            .get();
	     
	    System.out.println();
	    System.out.println("GET All StatusCode = " + response.getStatus());
	    System.out.println("GET All Headers = " + response.getHeaders());
	    System.out.println("GET Body (object list): ");
	    return Arrays.asList(response.readEntity(MobileOperatorDTO[].class));
	}
	
	/**
	 * Llamado a operación de consulta de todos los agentes de ventas.
	 * @return lista de agentes de ventas obtenidos.
	 */
	public List<SalesAgentDTO> getAllSalesAgents() {
		Client client = ClientBuilder.newClient(
	            new ClientConfig().register(JacksonJsonProvider.class));
	    WebTarget webTarget = client.target(URL_BASE_API).path(GET_ALL_SALES_AGENTS);
		
	    Response response = webTarget
	            .request(MediaType.APPLICATION_JSON_TYPE)
	            .get();
	     
	    System.out.println();
	    System.out.println("GET All StatusCode = " + response.getStatus());
	    System.out.println("GET All Headers = " + response.getHeaders());
	    System.out.println("GET Body (object list): ");
	    return Arrays.asList(response.readEntity(SalesAgentDTO[].class));
	}
	
	/**
	 * Método que llama a la operación de registro de una recarga, con los
	 * datos que fuero recibidos en el formulario.
	 * 
	 * @param saveRechargeInDTO datos del formulario
	 * @return Respuesta de la operación.
	 */
	public SaveRechargeOutDTO saveRecharge(SaveRechargeInDTO saveRechargeInDTO) {
		Client client = ClientBuilder.newClient(
	            new ClientConfig().register(JacksonJsonProvider.class));
	    WebTarget webTarget = client.target(URL_BASE_API).path(SAVE_RECHARGE);
	
		Response response = webTarget
		        .request()
		        .post(Entity.entity(saveRechargeInDTO, MediaType.APPLICATION_JSON_TYPE));
		 
		System.out.println();
		System.out.println("POST executed");
		System.out.println("POST StatusCode = " + response.getStatus());
		System.out.println("POST Header location = "
		        + response.getHeaders().get("location"));
		
		return response.readEntity(SaveRechargeOutDTO.class);
	}

}
