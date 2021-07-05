package com.adswaresystem.security.service;

import java.util.List;

import com.adswaresystem.clever.hotelier.clients.entity.ViewUser;

/**
 * The class SecurityController.
 * 
 * @author AdsWare System
 * 
 */
public interface RetrieveService {

	/**
	 * Method retrieveUsers.
	 * 
	 * @return the list of ViewUser object
	 */
	List<ViewUser> retrieveUsers();

}
