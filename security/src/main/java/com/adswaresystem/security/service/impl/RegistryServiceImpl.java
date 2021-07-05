package com.adswaresystem.security.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.entity.Users;
import com.adswaresystem.clever.hotelier.clients.model.RegistryRequest;
import com.adswaresystem.security.exceptions.custom.BadRequestException;
import com.adswaresystem.security.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.service.RegistryService;
import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.utils.Util;
import com.adswaresystem.security.validation.BusinessValidation;

import lombok.AllArgsConstructor;

/**
 * The class RegistryServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class RegistryServiceImpl implements RegistryService {

  /** The log attribute. */
  private static final Logger log = LoggerFactory.getLogger(RegistryServiceImpl.class);

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
   * Method to make the registry.
   * 
   * @param request The RegistryRequest object
   * @throws Exception 
   */
  @Override
  public void registry(RegistryRequest request) throws RuntimeException {
    
	// Validar restricciones del modelo
	removeSpacesBlank(request);
    Util.validateConstraints(request, businessValidation);
    validateModel(request);
    
    try {

      // Validar Usuario y nombre de usuario
      validateBusinessRules(request);

      // Insertar Usuario
      Users users = Users.builder()
          .name(request.getName())
          .middleName(request.getMiddleName())
          .lastName(request.getLastName())
          .email(request.getEmail())
          .userRole(request.getUserRole())
          .status(Constants.STATUS_DEFAULT)
          .build();
      usersRepository.save(users);
      
      // Insertar Credenciales de usuario
      Credentials credentials = Credentials.builder()
          .userId(users)
          .username(request.getUsername())
          .password(request.getPassword())
          .build();
      credentialsRepository.save(credentials);
      
      log.info(Constants.REGISTRY_SUCCESSFUL, request.getUsername());
    }  catch(Exception ex) {
      log.error(Constants.REGISTRY_FAILED, request.getUsername(), ex.getMessage());
      throw new InternalServerErrorException(ex.getMessage(), Constants.PATH_REGISTRY);
    }
    
  }

  /**
   * Method to validate business rules.
   * 
   * @param request the RegistryRequest object
   */
  private void validateBusinessRules(RegistryRequest request) {
	  
    // Validar usuario y nombre de usuario
    if(usersRepository.findByNameAndMiddleNameAndLastName(request.getName(),
        request.getMiddleName(), request.getLastName()).isPresent()) {
      log.error(Constants.USER_EXISTS, request.getName(), request.getMiddleName(), request.getLastName());
      throw new InternalServerErrorException(Constants.USER_EXISTS_EXCEPTION, Constants.PATH_REGISTRY);
    }
    
    // Validar numero maximo de super usuario
    if(request.getUserRole().equals(Constants.USER_ROL_SUPER_USER)) {
    	Optional<List<Users>> superUser = usersRepository.findByUserRole(Constants.USER_ROL_SUPER_USER);
        
        if(superUser.isPresent() && superUser.get().size() >= Constants.MAXIMUM_SUPER_USER) {
          log.error(Constants.MAXIMUM_ALLOWABLE_SUPER_USER, request.getUsername());
          throw new InternalServerErrorException(Constants.MAXIMUM_ALLOWABLE_SUPER_USER_EXCEPTION, Constants.PATH_REGISTRY);
        }
    }

    // Validar numero maximo de usuarios
    if(request.getUserRole().equals(Constants.USER_ROL_ADMINISTRATOR)) {
    	Optional<List<Users>> administrators = usersRepository.findByUserRole(Constants.USER_ROL_ADMINISTRATOR);
        
        if(administrators.isPresent() && administrators.get().size() >= Constants.MAXIMUM_ADMINISTRATORS) {
          log.error(Constants.MAXIMUM_ALLOWABLE_ADMINISTRATORS, request.getUsername());
          throw new InternalServerErrorException(Constants.MAXIMUM_ALLOWABLE_ADMINISTRATORS_EXCEPTION, Constants.PATH_REGISTRY);
        }
    }
    
    if(credentialsRepository.findByUsername(request.getUsername()).isPresent()) {
      log.error(Constants.USERNAME_EXISTS, request.getUsername());
      throw new InternalServerErrorException(Constants.USERNAME_EXISTS_EXCEPTION, Constants.PATH_REGISTRY);
    }
    
  }
  
  /**
   * Method validateModel.
   * 
   * @param request the request
   */
  private void validateModel(RegistryRequest request) {
	  
    Predicate<Integer> userRole = ur -> ur.equals(1) || ur.equals(2) || ur.equals(3);
	  
    // Validar Roles de usuarios permitidos
    if(!userRole.test(request.getUserRole())) {
      log.error(Constants.USERROL_INVALID, request.getUsername());
      throw new BadRequestException(Constants.USERROL_INVALID_EXCEPTION, Constants.USERROL_INVALID_EXCEPTION);
    }
    
    // Validar contraseña
 	StringBuilder response = new StringBuilder();
 	int capitalLetters = 0;
 	boolean flag = false;
 	int numbers = 0;
 	
     byte[] bytes = request.getPassword().trim().getBytes(StandardCharsets.US_ASCII);

     for(byte row : bytes) {
     	if(row >= 65 && row <= 90) {
     		capitalLetters++;
     	}
     	if(row >= 48 && row <= 57) {
     		numbers++;
     	}
     }
     
     if(capitalLetters > 2) {
     	response.append(Constants.CAPITAL_LETTERS_ERROR);
     	flag = true;
     }
     
     if(numbers > 3) {
     	response.append(Constants.NUMBERS_ERROR);
     	flag = true;
     }
     
     if(flag) {
     	log.error(response.toString());
         throw new BadRequestException(response.toString(), Constants.PATH_REGISTRY);
     }

    
  }
  
  public void removeSpacesBlank(RegistryRequest request) {
	  request.setUsername(request.getUsername().trim());
	  request.setPassword(request.getPassword().trim());
	  request.setEmail(request.getEmail().trim());
	  request.setName(request.getName().trim());
	  request.setMiddleName(request.getMiddleName().trim());
	  request.setLastName(request.getLastName().trim());
  }
  
}
