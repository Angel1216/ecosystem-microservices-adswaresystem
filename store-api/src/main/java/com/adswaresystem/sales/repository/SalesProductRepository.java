package com.adswaresystem.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adswaresystem.clever.hotelier.clients.entity.SalesProduct;

/**
 * The interface SalesProductRepository.
 * 
 * @author AdsWare System
 *
 */
public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer> {

}
