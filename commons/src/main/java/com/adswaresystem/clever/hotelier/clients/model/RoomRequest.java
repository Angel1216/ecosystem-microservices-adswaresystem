package com.adswaresystem.clever.hotelier.clients.model;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class RoomRequest {
	
	/** List to rooms.*/
	@NotNull
	private ArrayList<RoomInfoRequest> rooms;

}
