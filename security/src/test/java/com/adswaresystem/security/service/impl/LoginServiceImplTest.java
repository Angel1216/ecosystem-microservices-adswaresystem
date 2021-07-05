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
import com.adswaresystem.clever.hotelier.clients.entity.Users;
import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.security.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.security.exceptions.custom.UnauthorizedException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.validation.BusinessValidation;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
	
	@InjectMocks
	private LoginServiceImpl loginServiceImpl;
	
	/** The usersRepository attribute. */
	@Mock
	private UsersRepository usersRepository;
	  
	/** The credentialsRepository attribute. */
	@Mock
	private CredentialsRepository credentialsRepository;
	  
	/** The businessValidation attribute. */
	@Mock
	private BusinessValidation businessValidation;
	
	@Test(expected = UnauthorizedException.class)
	public void loginCredentialsNoOkTest() {
		
		CredentialsRequest request = new CredentialsRequest();
		request.setPassword("password");
		request.setUsername("username");
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		
		loginServiceImpl.login(request);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void loginUserNoOkTest() {
		CredentialsRequest request = new CredentialsRequest();
		request.setPassword("password");
		request.setUsername("username");
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		Credentials credentials = new Credentials();
		credentials.setCredentialId(1);
		credentials.setPassword("ewre");
		credentials.setUserId(new Users());
		credentials.setUsername("username");
		Optional<Credentials> userCredential = Optional.of(credentials); 
		
		when(credentialsRepository.findByUsernameAndPassword(Mockito.any(), Mockito.any())).thenReturn(userCredential);
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		loginServiceImpl.login(request);
	}
	
	@Test
	public void loginOkTest() {
		CredentialsRequest request = new CredentialsRequest();
		request.setPassword("password");
		request.setUsername("username");
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		Credentials credentials = new Credentials();
		credentials.setCredentialId(1);
		credentials.setPassword("ewre");
		credentials.setUserId(new Users());
		credentials.setUsername("username");
		Optional<Credentials> userCredential = Optional.of(credentials);
		
		Users users = new Users();
		Optional<Users> optUser = Optional.of(users);
		
		
		when(credentialsRepository.findByUsernameAndPassword(Mockito.any(), Mockito.any())).thenReturn(userCredential);
		when(usersRepository.findById(Mockito.any())).thenReturn(optUser);
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		loginServiceImpl.login(request);
	}

}
