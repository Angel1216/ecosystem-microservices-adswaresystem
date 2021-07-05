package com.adswaresystem.clever.hotelier.clients.model;

import java.time.ZonedDateTime;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.Data;

/** Class from room sale save. */
@Data
public class RoomSaleRequest {
	
	/** The sale_id attribute. */
	private Integer saleId;
	
	/** The payment_id attribute. */
	private Integer paymentId;
	
	/** The total_payment attribute. */
	@NotNull
	private Double totalPayment;
	
	/** The room_id attribute. */
	@NotNull
	private Integer roomId;
	
	/** The room_rate_id attribute. */
	@NotNull
	private Integer roomRateId;
	
	/** The payment_id attribute. */
	@NotNull
	@Pattern(regexp="^[C-D]{1,2}",message="PaymentType inválido")  
	private String paymentType;
	
	/** The sale_date attribute. */
	@NotNull
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private ZonedDateTime saleDate;
}
