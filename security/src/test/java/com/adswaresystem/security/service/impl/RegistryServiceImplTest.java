package com.adswaresystem.security.service.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;

import com.adswaresystem.clever.hotelier.clients.entity.Credentials;
import com.adswaresystem.clever.hotelier.clients.entity.Users;
import com.adswaresystem.clever.hotelier.clients.model.RegistryRequest;
import com.adswaresystem.security.exceptions.custom.BadRequestException;
import com.adswaresystem.security.exceptions.custom.InternalServerErrorException;
import com.adswaresystem.security.repository.CredentialsRepository;
import com.adswaresystem.security.repository.UsersRepository;
import com.adswaresystem.security.utils.Constants;
import com.adswaresystem.security.validation.BusinessValidation;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RegistryServiceImplTest {
	
	@InjectMocks
	private RegistryServiceImpl registryServiceImpl;
	
	/** The usersRepository attribute. */
	@Mock
	private UsersRepository usersRepository;
	  
	/** The credentialsRepository attribute. */
	@Mock
	private CredentialsRepository credentialsRepository;
	  
	/** The businessValidation attribute. */
	@Mock
	private BusinessValidation businessValidation;
	
	private RegistryRequest registryRequest;
	
	@Before
	public void init() {
		registryRequest = new RegistryRequest();
		registryRequest.setEmail("correo@msn.com");
		registryRequest.setLastName("Bernal");
		registryRequest.setMiddleName("Alarcon");
		registryRequest.setName("Zaida");
		registryRequest.setPassword("123");
		registryRequest.setUsername("zaida");
		registryRequest.setUserRole(1);
		
		Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void registryUserAlreadyExistsTest() {
		Users user = new Users();
		Optional<Users> optUser = Optional.of(user); 
		when(usersRepository.findByNameAndMiddleNameAndLastName(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(optUser);
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void registryManagerTest() {
		Users user = new Users();
		List<Users> lstUser = new ArrayList<>();
		lstUser.add(user);
		lstUser.add(user);
		lstUser.add(user);
		
		Optional<List<Users>> optAdministrators = Optional.of(lstUser);
		registryRequest.setUserRole(2);

		when(usersRepository.findByUserRole(Mockito.any())).thenReturn(optAdministrators);
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test
	public void registryManagerNoMaxTest() {
		registryRequest.setUserRole(2);
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void registryUserNameTest() {
		Credentials credentials = new Credentials();
		Optional<Credentials> optCredentials = Optional.of(credentials);

		when( credentialsRepository.findByUsername(Mockito.any())).thenReturn(optCredentials);
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test(expected = InternalServerErrorException.class)
	public void registryBDTest() {
		Credentials credentials = new Credentials();
		Optional<Credentials> optCredentials = Optional.of(credentials);

		when( credentialsRepository.findByUsername(Mockito.any())).thenThrow(new RuntimeException("error"));
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test(expected = BadRequestException.class)
	public void registryNoUserTest() {
		registryRequest.setUserRole(4);
		registryServiceImpl.registry(registryRequest);
	}
	
	@Test(expected = BadRequestException.class)
    public void updatePasswordNumberNoOkTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
		registryRequest.setUsername("username");
		registryRequest.setPassword("7t2r4E35");
    	registryServiceImpl.registry(registryRequest);
    }
    
    @Test(expected = BadRequestException.class)
    public void updatePasswordCapitalLetterNoOkTest() {
    	Map<String, Object> constraints = new HashMap<>();
		constraints.put("isError", "false");
		when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
		
    	registryRequest.setUsername("username");
    	registryRequest.setPassword("AtBr4C3D5");
    	registryServiceImpl.registry(registryRequest);
    }
    
    @Test(expected = InternalServerErrorException.class)
	public void registrySUNoMaxTest() {
    	Users userEntity = new Users();
    	List<Users> lstUsers = new ArrayList<>();
    	lstUsers.add(userEntity);
    	Optional<List<Users>> superUser = Optional.of(lstUsers);
    	when(usersRepository.findByUserRole(Mockito.any())).thenReturn(superUser);
		registryRequest.setUserRole(1);
		registryServiceImpl.registry(registryRequest);
	}


}
