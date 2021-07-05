package com.adswaresystem.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adswaresystem.clever.hotelier.clients.entity.Product;

/**
 * The interface ProductRepository.
 * 
 * @author AdsWare System
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
