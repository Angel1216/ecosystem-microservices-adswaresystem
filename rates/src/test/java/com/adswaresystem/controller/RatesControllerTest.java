package com.adswaresystem.controller;

import com.adsware.controller.RatesController;
import com.adsware.service.RatesService;
import com.adsware.validation.BusinessValidation;
import com.adswaresystem.clever.hotelier.clients.model.GenericObjectRequest;
import com.adswaresystem.clever.hotelier.clients.model.RoomRateRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RatesControllerTest {

    @InjectMocks
    private RatesController ratesController;

    /**
     * The ratesService attribute.
     */
    @Mock
    private RatesService ratesService;

    /**
     * The businessValidation attribute.
     */
    @Mock
    private BusinessValidation businessValidation;

    private RoomRateRequest request;

    private GenericObjectRequest deleteRequest;

    @Before
    public void init() {

        request = RoomRateRequest.builder()
                .roomId(1)
                .rateDescription("4 horas")
                .rate(500.00)
                .build();

        deleteRequest = new GenericObjectRequest();
        deleteRequest.setElementId(1);

        initMocks(this);
    }

    @Test
    public void createTest() throws Exception {
        assertNotNull(ratesController.create(request));
    }

    @Test
    public void updateTest() throws Exception {
        assertNotNull(ratesController.update(request));
    }

    @Test
    public void deleteTest() throws Exception {
        ratesController.delete(deleteRequest);
    }

    @Test
    public void retrieveTest() throws Exception {
        assertNotNull(ratesController.getAll());
    }

}
