package com.adswaresystem.security.service.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.entity.ViewUser;
import com.adswaresystem.security.repository.CustomRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RetrieveServiceImplTest {

	@InjectMocks
	private RetrieveServiceImpl retrieveServiceImpl;
	
	/** The customRepository attribute. */
	@Mock
	private CustomRepository customRepository;
	
	@Test
	public void retrieveUsersTest() {
		ViewUser viewUser = new ViewUser();
		List<ViewUser> lstVievUser = new ArrayList<>();
		lstVievUser.add(viewUser);
		when(customRepository.getUsers()).thenReturn(lstVievUser);
		retrieveServiceImpl.retrieveUsers();
	}
	
}
