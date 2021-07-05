package com.adswaresystem.security.service;

import com.adswaresystem.clever.hotelier.clients.model.RegistryRequest;

/**
 * The interface RegistryService.
 * 
 * @author AdsWare System
 *
 */
public interface RegistryService {
  
  /**
   * Method to make the registry.
   * 
   * @param request The RegistryRequest object
   * @throws Exception 
   */
  void registry(RegistryRequest request) throws RuntimeException;
  
}
