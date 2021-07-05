package com.adswaresystem.security.service;

import com.adswaresystem.clever.hotelier.clients.model.DeleteSecurityRequest;

/**
 * The interface DeleteService.
 * 
 * @author AdsWare System
 *
 */
public interface DeleteService {
	
	/**
	 * Method to delete the username.
	 * 
	 * @param request the request
	 */
	void delete(DeleteSecurityRequest request) throws RuntimeException;

}
