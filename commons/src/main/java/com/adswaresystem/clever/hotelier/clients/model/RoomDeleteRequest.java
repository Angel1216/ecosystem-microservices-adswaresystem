package com.adswaresystem.clever.hotelier.clients.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RoomDeleteRequest {
	
	/** Id of room */
	@NotNull
	private Integer roomId;
}
