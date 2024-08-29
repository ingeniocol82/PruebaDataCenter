package com.datacenter.recargas.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad JPA que mapea la tabla SALES_AGENT de la base de datos.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="SALES_AGENT")
public class SalesAgent {
	
	@Id
	@Column(name = "salesAgentCode")
	private Long salesAgentCode;
	@Column(name = "salesAgentFullName", nullable = false)
	private String salesAgentFullName;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rechargeSalesAgent", cascade = CascadeType.ALL)
	private List<Recharge> salesAgentRecharges;
}
