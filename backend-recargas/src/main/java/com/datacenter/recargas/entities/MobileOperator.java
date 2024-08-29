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
 * Entidad JPA que mapea la tabla MOBILE_OPERATOR de la base de datos.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MOBILE_OPERATOR")
public class MobileOperator {
	@Id
	@Column(name = "mobileOperatorId")
	private Integer mobileOperatorId;
	
	@Column(name = "mobileOperatorName", nullable = false)
	private String mobileOperatorName;
	
	@JsonIgnore 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rechargeMobileOperator", cascade = CascadeType.ALL)
	private List<Recharge> mobileOperatorRecharges;
}
