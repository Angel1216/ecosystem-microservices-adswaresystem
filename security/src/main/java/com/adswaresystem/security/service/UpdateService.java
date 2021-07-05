package com.adswaresystem.security.service;

import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;

/**
 * The interface UpdateService.
 * 
 * @author AdsWare System
 *
 */
public interface UpdateService {
	
	/**
	 * Method to update the password.
	 * 
	 * @param request the request
	 */
	void update(CredentialsRequest request) throws RuntimeException;

}
