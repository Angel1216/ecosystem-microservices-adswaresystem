package com.adswaresystem.clever.hotelier.clients.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class Users.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "users")
public class Users implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 7031155399730719773L;
	
	/** The userId attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	/** The name attribute. */
	@Column(name = "user_name", nullable = false, length = 50)
	private String name;
	
	/** The middleName attribute. */
	@Column(name = "user_middle_name", nullable = false, length = 50)
	private String middleName;
	
	/** The lastName attribute. */
	@Column(name = "user_last_name", nullable = false, length = 50)
	private String lastName;
	
	/** The email attribute. */
	@Column(name = "user_email", nullable = false, length = 50)
	private String email;
	
	/** The userRole attribute. */
	@Column(name = "user_role", nullable = false)
	private Integer userRole;
	
	/** The status attribute. */
	@Column(name = "status", nullable = false)
	private Boolean status;
	
	/**
	 * The default builder.
	 */
	public Users() {
		
	}
	
}
