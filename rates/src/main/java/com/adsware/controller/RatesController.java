package com.adsware.controller;

import com.adsware.exceptions.custom.InternalServerErrorException;
import com.adsware.service.RatesService;
import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import com.adswaresystem.clever.hotelier.clients.model.GenericObjectRequest;
import com.adswaresystem.clever.hotelier.clients.model.RoomRateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rate")
@Api(value = "onlinestock", description = "Operations pertaining to products in Online Store",
        tags = "Rates")
@RequiredArgsConstructor
public class RatesController {

    final RatesService service;

    @ApiOperation(value = "View a list of available rates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @GetMapping
    public Iterable<RoomRate> getAll() {
        return service.findAllRates();
    }

    @ApiOperation(value = "Add a new rate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> create(@RequestBody RoomRateRequest request) throws InternalServerErrorException {
        service.registerRate(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete the selected rate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @PostMapping(path = "/delete")
    public void delete(@RequestBody GenericObjectRequest delete) throws InternalServerErrorException {
        service.deleteRate(delete);
    }

    @ApiOperation(value = "Update a rate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    @PutMapping(path = "/edit/")
    public ResponseEntity<Void> update(@RequestBody RoomRateRequest updateProduct) throws Exception {
        service.updateRate(updateProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}