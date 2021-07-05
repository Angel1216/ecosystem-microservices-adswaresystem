package com.adswaresystem.security.service.impl;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.security.exceptions.custom.BadRequestException;
import com.adswaresystem.security.exceptions.custom.NotFoundException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.validation.BusinessValidation;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UpdateServiceImplTest {

	@InjectMocks
	private UpdateServiceImpl updateServiceImpl;
	
	/** The credentialsRepository attribute. */
    @Mock
    private CredentialsRepository credentialsRepository;
	  
    /** The businessValidation attribute. */
    @Mock
    private BusinessValidation businessValidation;
    
    @Test
    public void updateTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		
		Credentials credentials = new Credentials();
		credentials.setUsername("username");
		credentials.setPassword("ht2r4EfR");
		Optional<Credentials> userCredential = Optional.of(credentials); 
		
		when(credentialsRepository.findByUsername(Mockito.any())).thenReturn(userCredential);
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
    	CredentialsRequest request = new CredentialsRequest();
    	request.setUsername("username");
    	request.setPassword("ht2r4EfR");
    	updateServiceImpl.update(request);
    }
    
    @Test(expected = NotFoundException.class)
    public void updateNoOkTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
    	CredentialsRequest request = new CredentialsRequest();
    	request.setUsername("username");
    	request.setPassword("ht2r4EfR");
    	updateServiceImpl.update(request);
    }
    
    @Test(expected = BadRequestException.class)
    public void updatePasswordNumberNoOkTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
    	CredentialsRequest request = new CredentialsRequest();
    	request.setUsername("username");
    	request.setPassword("7t2r4E35");
    	updateServiceImpl.update(request);
    }
    
    @Test(expected = BadRequestException.class)
    public void updatePasswordCapitalLetterNoOkTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
    	CredentialsRequest request = new CredentialsRequest();
    	request.setUsername("username");
    	request.setPassword("AtBr4C3D5");
    	updateServiceImpl.update(request);
    }
	
}
