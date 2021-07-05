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
import com.adswaresystem.clever.hotelier.clients.model.DeleteSecurityRequest;
import com.adswaresystem.security.exceptions.custom.NotFoundException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.validation.BusinessValidation;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DeleteServiceImplTest {
	
	@InjectMocks
	private DeleteServiceImpl deleteServiceImpl;
	
	/** The usersRepository attribute. */
	@Mock
	private UsersRepository usersRepository;
	  
	/** The credentialsRepository attribute. */
	@Mock
	private CredentialsRepository credentialsRepository;
	  
	/** The businessValidation attribute. */
	@Mock
	private BusinessValidation businessValidation;

	@Test
	public void deleteServiceImplTest() {
		DeleteSecurityRequest request = new DeleteSecurityRequest();
		request.setUsername("username");
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		
		Credentials credentials = new Credentials();
		Optional<Credentials> userCredential = Optional.of(credentials); 
		
		when(credentialsRepository.findByUsername(Mockito.any())).thenReturn(userCredential);
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		deleteServiceImpl.delete(request);
	}
	
	@Test(expected = NotFoundException.class)
	public void deleteServiceImplNoOkTest() {
		DeleteSecurityRequest request = new DeleteSecurityRequest();
		request.setUsername("username");
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		deleteServiceImpl.delete(request);
	}

}
