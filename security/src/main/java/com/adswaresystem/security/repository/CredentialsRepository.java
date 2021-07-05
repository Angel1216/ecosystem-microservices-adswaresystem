package com.adswaresystem.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;

/**
 * The interface CredentialsRepository.
 * 
 * @author AdsWare System
 *
 */
public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {
  
  /**
   * Method to find user by username and password.
   * @param usuario
   * @param contrasena
   * 
   * @return the object Credentials
   */
  Optional<Credentials> findByUsernameAndPassword(String username, String password);
  
  /**
   * Method to find user by username.
   * @param usuario
   * 
   * @return the object Credentials
   */
  Optional<Credentials> findByUsername(String username);
  
}
