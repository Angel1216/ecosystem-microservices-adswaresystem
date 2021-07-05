package com.adswaresystem.service;

import com.adsware.exceptions.custom.InternalServerErrorException;
import com.adsware.repository.RatesRepository;
import com.adsware.repository.RoomRepository;
import com.adsware.service.RatesService;
import com.adsware.validation.BusinessValidation;
import com.adswaresystem.clever.hotelier.clients.entity.Room;
import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.adswaresystem.factory.ObjectFactory.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RatesServiceTest {

    @InjectMocks
    private RatesService ratesService;

    /**
     * The usersRepository attribute.
     */
    @Mock
    private RoomRepository roomRepository;

    /**
     * The credentialsRepository attribute.
     */
    @Mock
    private RatesRepository ratesRepository;

    /**
     * The businessValidation attribute.
     */
    @Mock
    private BusinessValidation businessValidation;

    @Before
    public void init() {
        initMocks(this);
    }

    @Test
    public void retrieveRatesTest() {
        when(ratesRepository.findAll()).thenReturn(createRatesList());
        assertNotNull(ratesService.findAllRates());
    }

    @Test
    public void createRateTest() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        Optional<Room> entityRoom = Optional.of(createRoom());

        when(roomRepository.findById(Mockito.any())).thenReturn(entityRoom);
        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);

        ratesService.registerRate(createRoomRateRequest());
    }

    @Test
    public void updateRateTest() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        Optional<Room> entityRoom = Optional.of(createRoom());

        when(roomRepository.findById(Mockito.any())).thenReturn(entityRoom);
        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);

        ratesService.updateRate(createRoomRateRequest());

    }

    @Test
    public void deleteRateTest() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        Optional<RoomRate> entityRate = Optional.of(createRoomRate());

        when(ratesRepository.findById(Mockito.any())).thenReturn(entityRate);
        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);

        ratesService.deleteRate(createGenericObjectRequest(1));
    }

    @Test(expected = InternalServerErrorException.class)
    public void createRateThrowsError_whenRequestMalformed() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
        when(roomRepository.findById(Mockito.any())).thenThrow(InternalServerErrorException.class);

        ratesService.registerRate(createRoomRateMalformedRequest());

    }

    @Test(expected = InternalServerErrorException.class)
    public void deleteRateTest_whenRequestMalformed() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);

        when(ratesRepository.findById(Mockito.any()))
                .thenThrow(InternalServerErrorException.class);

        ratesService.deleteRate(createGenericObjectRequest(0));
    }

    @Test(expected = InternalServerErrorException.class)
    public void updateRateTest_whenRequestMalformed() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(roomRepository.findById(Mockito.any()))
                .thenThrow(InternalServerErrorException.class);
        when(businessValidation.validateConstraintsGenerics(Mockito.any()))
                .thenReturn(constraints);

        ratesService.updateRate(createRoomRateRequest());

    }
    
    @Test(expected = InternalServerErrorException.class)
    public void createRateThrowsError_whenRequestMalformedLambda() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);
        when(roomRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        
        ratesService.registerRate(createRoomRateMalformedRequest());
    }
    
    @Test(expected = InternalServerErrorException.class)
    public void deleteRateTest_whenRequestMalformedLambda() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(businessValidation.validateConstraintsGenerics(Mockito.any())).thenReturn(constraints);

        when(ratesRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());

        ratesService.deleteRate(createGenericObjectRequest(0));
    }
    
    @Test(expected = InternalServerErrorException.class)
    public void updateRateTest_whenRequestMalformedLambda() {
        Map<String, Object> constraints = new HashMap<>();
        constraints.put("isError", "false");

        when(roomRepository.findById(Mockito.any()))
                .thenReturn(Optional.empty());
        when(businessValidation.validateConstraintsGenerics(Mockito.any()))
                .thenReturn(constraints);

        ratesService.updateRate(createRoomRateRequest());

    }

}
