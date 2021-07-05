package com.adswaresystem.security.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.adswaresystem.clever.hotelier.clients.entity.ViewUser;

/**
 * The interface CustomRepository.
 * 
 * @author AdsWare System
 *
 */
@Repository
@Transactional
public class CustomRepository {
	
  @PersistenceContext
  private EntityManager em;
  
  public List<ViewUser> getUsers() {
	  List<ViewUser> listaFactura = em.createQuery("SELECT v FROM ViewUser v", ViewUser.class).getResultList();
	  return listaFactura;
  }
}
