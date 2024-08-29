package com.datacenter.recargas.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad JPA que mapea la tabla RECHARGE de la base de datos.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "RECHARGE")
public class Recharge {
	@Id @GeneratedValue
	@Column(name = "rechargeId")
	private Long rechargeId;
	
	@Column(name = "rechargeMobileNumber", nullable = false)
	private String rechargeMobileNumber;
	
	@Column(name = "rechargeAmount", nullable = false)
	private BigDecimal rechargeAmount;
	
	@Column(name = "rechargeCreationDateTime", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
    private Date rechargeCreationDateTime;

	@JoinColumn(name = "rechargeMobileOperatorId", referencedColumnName = "mobileOperatorId", insertable = true, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private MobileOperator rechargeMobileOperator;
	
	@JoinColumn(name = "rechargeSalesAgentCode", referencedColumnName = "salesAgentCode" , insertable = true, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SalesAgent rechargeSalesAgent;
}
