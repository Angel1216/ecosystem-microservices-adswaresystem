package com.adswaresystem.security.exceptions;

import java.time.ZonedDateTime;

import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.utils.Util;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Setter;

/**
 * The class ErrorResponse.
 * 
 * @author AdsWare System
 *
 */
@Setter
public class ErrorResponse {
	
	private String type;
	
	private String code;
	
	private String details;
	
	private String location;
	
	private String moreInfo;
	
	private ZonedDateTime timestamp;

	public String getType() {
		return (String) Util.defaultValue(type, Constants.EMPTY_STRING);
	}

	public String getCode() {
		return (String) Util.defaultValue(code, Constants.EMPTY_STRING);
	}

	public String getDetails() {
		return (String) Util.defaultValue(details, Constants.EMPTY_STRING);
	}

	public String getLocation() {
		return (String) Util.defaultValue(location, Constants.EMPTY_STRING);
	}

	public String getMoreInfo() {
		return (String) Util.defaultValue(moreInfo, Constants.EMPTY_STRING);
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING,
	    pattern = Constants.ERR_TIME_PATTERN)
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	
}
