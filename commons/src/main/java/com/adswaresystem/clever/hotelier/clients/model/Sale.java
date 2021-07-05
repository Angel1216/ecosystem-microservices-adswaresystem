package com.adswaresystem.clever.hotelier.clients.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class Sale.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@ApiModel(description = "Detalle de venta")
public class Sale {
	
	/** The productId attribute. */
	private Integer productId;
	
	/** The productQuantity attribute. */
	private Integer productQuantity;
	
	/** The sellPrice attribute. */
	private Double sellPrice;
	
}
