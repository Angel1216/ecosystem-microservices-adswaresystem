package com.adswaresystem.clever.hotelier.clients.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class ViewUser.
 * 
 * @author AdsWare System
 *
 */
@Entity
@Table(name = "view_user")
@Immutable
public class ViewUser implements Serializable {
	
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 7031155399730719773L;
	
	/** The userId attribute. */
	@Id
	@JsonIgnore
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	/** The name attribute. */
	@JsonProperty(value = "name")
	@Column(name = "user_name", nullable = false, length = 50)
	private String name;
	
	/** The middleName attribute. */
	@JsonProperty(value = "middleName")
	@Column(name = "user_middle_name", nullable = false, length = 50)
	private String middleName;
	
	/** The lastName attribute. */
	@JsonProperty(value = "lastName")
	@Column(name = "user_last_name", nullable = false, length = 50)
	private String lastName;
	
	/** The username attribute. */
	@JsonProperty(value = "username")
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	/** The userRole attribute. */
	@JsonProperty(value = "userRole")
	@Column(name = "user_role", nullable = false)
	private Integer userRole;
	
	/** The status attribute. */
	@JsonProperty(value = "status")
	@Column(name = "status", nullable = false)
	private Boolean status;

}
