package com.adswaresystem.security.exceptions.custom;

import lombok.Getter;

/**
 * The class InternalServerErrorException.
 * 
 * @author AdsWare System
 *
 */
@Getter
public class InternalServerErrorException extends RuntimeException {

	/**
	 * The serialVersionUID attribute.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The location attribute.
	 */
	private final String location;
	
	/**
	 * The moreInfo attribute.
	 */
	private final String moreInfo;
	
	/**
	 * Builder.
	 * 
	 * @param message The message to describe the error
	 * @param location The location where the error ocurred
	 */
	public InternalServerErrorException(String message, String location) {
		super(message);
		this.location = location;
		this.moreInfo = "";
	}
	
	/**
	 * Builder.
	 * 
	 * @param message The message to describe the error
	 * @param location The location where the error ocurred
	 * @param moreInfo Extra information to describe the error
	 */
	public InternalServerErrorException(String message, String location, String moreInfo) {
		super(message);
		this.location = location;
		this.moreInfo = moreInfo;
	}
	
	/**
	 * Builder.
	 * 
	 * @param throwable The exception generated
	 * @param location The location where the error ocurred
	 */
	public InternalServerErrorException(Throwable throwable, String location) {
		super(throwable);
		this.location = location;
		this.moreInfo = throwable.getCause().toString();
	}

}
