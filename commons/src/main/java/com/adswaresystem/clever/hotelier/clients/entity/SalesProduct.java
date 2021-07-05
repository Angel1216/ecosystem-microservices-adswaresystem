package com.adswaresystem.clever.hotelier.clients.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class SalesProduct.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "sale_product")
public class SalesProduct implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The salesId attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sale", nullable = false)
	private Integer salesId;

	/** The salesAmount attribute. */
	@Column(name = "sales_amount", nullable = false)
	private Double salesAmount;

	/** The sell_date attribute. */
	@Column(name = "sell_date", nullable = false)
	private ZonedDateTime sell_date;
	
	/** The iva attribute. */
	@Column(name = "taxes", nullable = false)
	private Double taxes;
	
	/** The customerId attribute. */
	@Column(name = "customerId", nullable = true)
	private Integer customerId;
	
	/**
	 * The default builder.
	 */
	public SalesProduct() {
		
	}

}
