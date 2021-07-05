package com.adswaresystem.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adswaresystem.clever.hotelier.clients.entity.ViewUser;
import com.adswaresystem.security.repository.CustomRepository;
import com.adswaresystem.security.service.RetrieveService;

/**
 * The class RetrieveServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
public class RetrieveServiceImpl implements RetrieveService {
	
	/** The customRepository attribute. */
	@Autowired
	private CustomRepository customRepository;

	/**
	 * Method retrieveUsers.
	 * 
	 * @return the list of ViewUser object
	 */
	@Override
	public List<ViewUser> retrieveUsers() {
		return customRepository.getUsers();
	}

}
