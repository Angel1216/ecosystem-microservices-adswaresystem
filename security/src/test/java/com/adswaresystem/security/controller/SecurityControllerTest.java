package com.adswaresystem.security.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.clever.hotelier.clients.model.DeleteSecurityRequest;
import com.adswaresystem.clever.hotelier.clients.model.RegistryRequest;
import com.adswaresystem.security.service.DeleteService;
import com.adswaresystem.security.service.LoginService;
import com.adswaresystem.security.service.RegistryService;
import com.adswaresystem.security.service.RetrieveService;
import com.adswaresystem.security.service.UpdateService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SecurityControllerTest {
	
	@InjectMocks
	private SecurityController securityController;
	
	/** The service for registry. */
	@Mock
	private RegistryService registryService;

	/** The service for login. */
	@Mock
	private LoginService loginService;
  
	/** The service for update. */
	@Mock
	private UpdateService updateService;
  
	/** The service for delete. */
	@Mock
	private DeleteService deleteService;
  
	/** The service for retrieve */
	@Mock
	private RetrieveService retrieveService;
	
	@Test
	public void registryTest() throws Exception {
		assertNotNull(securityController.registry(new RegistryRequest()));
	}
	
	@Test
	public void loginTest() throws Exception {
		assertNotNull(securityController.login(new CredentialsRequest()));
	}
	
	@Test
	public void updateTest() throws Exception {
		assertNotNull(securityController.update(new CredentialsRequest()));
	}
	
	@Test
	public void deleteTest() throws Exception {
		assertNotNull(securityController.delete(new DeleteSecurityRequest()));
	}
	
	@Test
	public void retrieveTest() throws Exception {
		assertNotNull(securityController.retrieve());
	}

}
