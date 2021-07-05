package com.adswaresystem.clever.hotelier.clients.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {
	
	/** id from room type. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_type_id")
	private Integer roomTypeId;
	
	/** Description to room. */
	@Column(name = "room_type_description")
	private String roomTypeDescription;
}
