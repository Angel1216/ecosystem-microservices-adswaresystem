package com.example.jpa.entity;

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

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "welcome")
public class WelcomeEntity implements Serializable {
	
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

}
