package com.adswaresystem.sales.service;

import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;

/**
 * The interface RegistryService.
 * 
 * @author AdsWare System
 *
 */
public interface SalesService {
  
  /**
   * Method to make the registry.
   * 
   * @param request The RegistryRequest object
   * @throws Exception 
   */
  void saveSaleDetail(SaleDetailRequest request) throws Exception;
  
}
