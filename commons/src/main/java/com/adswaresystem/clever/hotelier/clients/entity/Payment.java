package com.adswaresystem.clever.hotelier.clients.entity;

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
@Table(name = "payment")
public class Payment {
	
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The payment_id attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", nullable = false)
	private Integer paymentId;

	/** The total_payment attribute. */
	@Column(name = "total_payment")
	private Double totalPayment;
	
	/** The payment_type attribute. */
	@Column(name = "payment_type")
	private String paymentType;
}
