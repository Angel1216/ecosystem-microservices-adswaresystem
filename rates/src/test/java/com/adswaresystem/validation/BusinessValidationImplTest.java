package com.adswaresystem.validation;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.adsware.validation.BusinessValidationImpl;
import com.adswaresystem.clever.hotelier.clients.entity.Room;
import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.adswaresystem.clever.hotelier.clients.model.RoomRateRequest;
import com.adswaresystem.clever.hotelier.clients.model.Sale;
import com.adswaresystem.clever.hotelier.clients.model.SaleDetailRequest;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BusinessValidationImplTest {
	
	@InjectMocks
	private BusinessValidationImpl businessValidationImpl;
	
	@Test
	public void validateConstraintsGenericsNoOkTest() {
		RoomRate room = RoomRate.builder().build();
		businessValidationImpl.validateConstraintsGenerics(room);
	}
	
	@Test
	public void validateConstraintsGenericsOkTest() {
		RoomRateRequest roomRateRequest = RoomRateRequest.builder()
				.rateDescription(null)
				.rate(null)
				.build();
				
		
		assertNotNull(businessValidationImpl.validateConstraintsGenerics(roomRateRequest));
	}

}
