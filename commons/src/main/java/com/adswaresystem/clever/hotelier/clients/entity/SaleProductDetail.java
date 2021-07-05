package com.adswaresystem.clever.hotelier.clients.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sale_product_detail")
public class SaleProductDetail implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The salesId attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer saleDetailId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_sale", referencedColumnName = "id_sale", nullable = false)
	private SalesProduct saleId;
	
	/** The productId attribute. */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
	private Product productId;
	
	/** The productQuantity attribute. */
	@Column(name = "product_quantity", nullable = false)
	private Integer productQuantity;
	
	/** The sellPrice attribute. */
	@Column(name = "sell_price", nullable = false)
	private Double sellPrice;
	
	/**
	 * The default builder.
	 */
	public SaleProductDetail() {
		
	}

}
