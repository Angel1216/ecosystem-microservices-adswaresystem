package com.adswaresystem.clever.hotelier.clients.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RoomInfoRequest {
	
	/** Id of room */
	private Integer roomId;
	
	/** Name of room */
	@NotNull
	private String roomKey;
	
	/** The id from room type. */
	@NotNull
	private Integer roomTypeId;

	/**The room status attribute*/
	@NotNull
	@NotBlank
	private RoomStatus status;
}
