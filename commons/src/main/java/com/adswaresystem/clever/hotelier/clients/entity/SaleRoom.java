package com.adswaresystem.clever.hotelier.clients.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Product entity.
 */
@Entity
@Data
@Table(name = "sale_room")
public class SaleRoom {
	
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The sale_id attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id", nullable = false)
	private Integer saleId;
	
	/** The sale_date attribute. */
	@Column(name = "sale_date")
	private ZonedDateTime saleDate;
	
	/** The room_id attribute. */
	@Column(name = "room_id")
	private Integer roomId;
	
	/** The room_rate_id attribute. */
	@Column(name = "room_rate_id")
	private Integer roomRateId;
	
	/** The payment_id attribute. */
	@Column(name = "payment_id")
	private Integer paymentId;
	
}
