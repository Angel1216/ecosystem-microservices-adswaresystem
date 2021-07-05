package com.adswaresystem.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adswaresystem.clever.hotelier.clients.entity.Customer;

/**
 * The interface CustomerRepository.
 * 
 * @author AdsWare System
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
