package com.adswaresystem.security.service.impl;

import java.util.Optional; 

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.model.DeleteSecurityRequest;
import com.adswaresystem.security.exceptions.custom.NotFoundException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.service.DeleteService;
import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.utils.Util;
import com.adswaresystem.security.validation.BusinessValidation;

import lombok.AllArgsConstructor;

/**
 * The class DeleteServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class DeleteServiceImpl implements DeleteService {
	
  /** The log attribute. */
  private static final Logger log = LoggerFactory.getLogger(DeleteServiceImpl.class);
  
  /** The usersRepository attribute. */
  @Autowired
  private UsersRepository usersRepository;
  
  /** The credentialsRepository attribute. */
  @Autowired
  private CredentialsRepository credentialsRepository;
  
  /** The businessValidation attribute. */
  @Autowired
  private BusinessValidation businessValidation;
  
  /**
   * Method to delete the username.
   * 
   * @param request the request
   */
  @Override
  public void delete(DeleteSecurityRequest request) throws RuntimeException {
	  
    // Validar restricciones del modelo
	removeSpacesBlank(request);
    Util.validateConstraints(request, businessValidation);
      
    Optional<Credentials> userCredential = credentialsRepository.findByUsername(request.getUsername());

    if(userCredential.isPresent()) {
      credentialsRepository.delete(userCredential.get());
      usersRepository.delete(userCredential.get().getUserId());
    } else {
      log.error(Constants.USERNAME, request.getUsername());
      throw new NotFoundException(Constants.USERNAME_EXCEPTION, Constants.PATH_DELETE);
    }
      
  }
  
  public void removeSpacesBlank(DeleteSecurityRequest request) {
	  request.setUsername(request.getUsername().trim());
  }

}
