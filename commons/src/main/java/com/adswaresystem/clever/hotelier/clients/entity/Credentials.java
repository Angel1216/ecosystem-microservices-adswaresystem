package com.adswaresystem.clever.hotelier.clients.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class Credentials.
 * 
 * @author AdsWare System
 *
 */
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "credential")
public class Credentials implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = -3831113243394208349L;

	/** The credentialId attribute. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credential_id", nullable = false)
	private Integer credentialId;
	
	/** The userId attribute. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private Users userId;

	/** The username attribute. */
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	/** The password attribute. */
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	/**
	 * The default builder.
	 */
	public Credentials() {
		
	}

}
