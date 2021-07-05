package com.adswaresystem.security.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.entity.Users;
import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.clever.hotelier.clients.model.LoginResponse;
import com.adswaresystem.security.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.security.exceptions.custom.UnauthorizedException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.service.LoginService;
import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.utils.Util;
import com.adswaresystem.security.validation.BusinessValidation;

import lombok.AllArgsConstructor;

/**
 * The class LoginServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class LoginServiceImpl implements LoginService  {
  
  /** The log attribute. */
  private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
  
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
   * Method to make a login.
   * 
   * @param request The LoginRequest object
   * @return the object LoginResponse
   */
  @Override
  public LoginResponse login(CredentialsRequest request) {

    // Validar restricciones del modelo
	removeSpacesBlank(request);
    Util.validateConstraints(request, businessValidation);
    
    Optional<Credentials> credentialsUser = credentialsRepository.findByUsernameAndPassword(request.getUsername(),
            request.getPassword());
    
    // Validar credenciales del usuario
    if(!credentialsUser.isPresent()) {
      log.error(Constants.INVALID_CREDENTIALS, request.getUsername());
      throw new UnauthorizedException(Constants.INVALID_CREDENTIALS_EXCEPTION, Constants.PATH_LOGIN);
    }
    
    Optional<Users> user = usersRepository.findById(credentialsUser.get().getUserId().getUserId());
    if(!user.isPresent()) {
        log.error(Constants.INVALID_USER, request.getUsername());
        throw new InternalServerErrorException(Constants.INVALID_USER_EXCEPTION, Constants.PATH_LOGIN);
      }
    
    return LoginResponse.builder().name(user.get().getName()).middleName(user.get().getMiddleName()).userRole(user.get().getUserRole()).build();
    
  }
  
  public void removeSpacesBlank(CredentialsRequest request) {
	  request.setUsername(request.getUsername().trim());
	  request.setPassword(request.getPassword().trim());
  }
  
}
