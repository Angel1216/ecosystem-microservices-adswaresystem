package com.adswaresystem.clever.hotelier.clients.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class Room {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/** The room id attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Integer roomId;
	
	/** The name from room key. */
	@Column(name = "room_key")
	private String roomKey;
	
	/** The id from room type. */
	@JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id", nullable = false)
	@Column(name = "room_type_id")
	private Integer roomTypeId;

	@Column(name = "room_status", nullable = false)
	private String roomStatus;
}
