package com.adswaresystem.security.exceptions.custom;

import lombok.Getter;

/**
 * The class BadRequestException.
 * 
 * @author AdsWare System
 *
 */
@Getter
public class BadRequestException extends RuntimeException {

	/**
	 * The serialVersionUID attribute.
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	 * The badFields attribute.
	 */
	private final String badFields;
	
	/**
	 * Builder.
	 * 
	 * @param message The message to describe the error
	 * @param badFields The wrong fields
	 */
	public BadRequestException(String message, String badFields) {
		super(message);
		this.badFields = badFields;
	}

}
