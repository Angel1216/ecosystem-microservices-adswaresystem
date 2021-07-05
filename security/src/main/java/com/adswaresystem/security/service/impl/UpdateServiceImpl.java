package com.adswaresystem.security.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.security.exceptions.custom.BadRequestException;
import com.adswaresystem.security.exceptions.custom.NotFoundException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.service.UpdateService;
import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.utils.Util;
import com.adswaresystem.security.validation.BusinessValidation;

import lombok.AllArgsConstructor;

/**
 * The class UpdateServiceImpl.
 * 
 * @author AdsWare System
 *
 */
@Service
@Transactional
@AllArgsConstructor
public class UpdateServiceImpl implements UpdateService {
	
	/** The log attribute. */
	private static final Logger log = LoggerFactory.getLogger(UpdateServiceImpl.class);
	
	/** The credentialsRepository attribute. */
    @Autowired
    private CredentialsRepository credentialsRepository;
	  
    /** The businessValidation attribute. */
    @Autowired
    private BusinessValidation businessValidation;

    /**
     * Method to update the password.
     * 
     * @param request the request
     */
	@Override
	public void update(CredentialsRequest request) throws RuntimeException {
		
      // Validar restricciones del modelo
	  removeSpacesBlank(request);
      Util.validateConstraints(request, businessValidation);
      validateModel(request);
      
      Optional<Credentials> userCredential = credentialsRepository.findByUsername(request.getUsername());
      
      if(userCredential.isPresent()) {
        userCredential.get().setPassword(request.getPassword());
        credentialsRepository.save(userCredential.get());
      } else {
        log.error(Constants.USERNAME, request.getUsername());
        throw new NotFoundException(Constants.USERNAME_EXCEPTION, Constants.PATH_UPDATE);
      }
		
	}
	
	/**
	 * Method validateModel.
	 * 
	 * @param request the request
	 */
	private void validateModel(CredentialsRequest request) {

		// Validar contraseña
		StringBuilder response = new StringBuilder();
		int capitalLetters = 0;
		boolean flag = false;
		int numbers = 0;

		byte[] bytes = request.getPassword().trim().getBytes(StandardCharsets.US_ASCII);

		for (byte row : bytes) {
			if (row >= 65 && row <= 90) {
				capitalLetters++;
			}
			if (row >= 48 && row <= 57) {
				numbers++;
			}
		}

		if (capitalLetters > 2) {
			response.append(Constants.CAPITAL_LETTERS_ERROR);
			flag = true;
		}

		if (numbers > 3) {
			response.append(Constants.NUMBERS_ERROR);
			flag = true;
		}

		if (flag) {
			log.error(response.toString());
			throw new BadRequestException(response.toString(), Constants.PATH_REGISTRY);
		}

	}
	
	public void removeSpacesBlank(CredentialsRequest request) {
		  request.setUsername(request.getUsername().trim());
		  request.setPassword(request.getPassword().trim());
	 }

}
