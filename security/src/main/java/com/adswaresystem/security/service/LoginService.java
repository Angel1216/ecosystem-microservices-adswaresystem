package com.adswaresystem.security.service;

import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.clever.hotelier.clients.model.LoginResponse;

/**
 * The interface LoginService.
 * 
 * @author AdsWare System
 *
 */
public interface LoginService {
  
  /**
   * Method to make a login.
   * 
   * @param request The LoginRequest object
   * @return the object LoginResponse 
   */
	LoginResponse login(CredentialsRequest request);
  	
}
