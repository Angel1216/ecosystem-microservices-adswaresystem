package com.adswaresystem.clever.hotelier.clients.model;

import java.time.ZonedDateTime;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * The class FindBetweenDatesRequest.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@ApiModel(description = "Solicitud de búsqueda entre fechas")
public class FindBetweenDatesRequest {
	
	/** Search start date. */
	@NotNull
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private ZonedDateTime startDate;
	
	/** Search finish date. */
	@NotNull
	@Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
	private ZonedDateTime finishDate;
}
