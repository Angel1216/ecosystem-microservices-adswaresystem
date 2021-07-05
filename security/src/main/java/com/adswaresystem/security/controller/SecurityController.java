package com.adswaresystem.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adswaresystem.clever.hotelier.clients.entity.ViewUser;
import com.adswaresystem.clever.hotelier.clients.model.CredentialsRequest;
import com.adswaresystem.clever.hotelier.clients.model.DeleteSecurityRequest;
import com.adswaresystem.clever.hotelier.clients.model.LoginResponse;
import com.adswaresystem.clever.hotelier.clients.model.RegistryRequest;
import com.adswaresystem.security.service.DeleteService;
import com.adswaresystem.security.service.LoginService;
import com.adswaresystem.security.service.RegistryService;
import com.adswaresystem.security.service.RetrieveService;
import com.adswaresystem.security.service.UpdateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The class SecurityController.
 * 
 * @author AdsWare System
 * 
 */
@RequestMapping("${api.basepath}")
@RestController
@Api(value = "security", description = "Operations registry and login in security")
public class SecurityController {
  
  /** The service for registry. */
  @Autowired
  private RegistryService registryService;

  /** The service for login. */
  @Autowired
  private LoginService loginService;
  
  /** The service for update. */
  @Autowired
  private UpdateService updateService;
  
  /** The service for delete. */
  @Autowired
  private DeleteService deleteService;
  
  /** The service for retrieve */
  @Autowired
  private RetrieveService retrieveService;
  
  /**
   * Method to make the user registry.
   * 
   * @param request The RegistryRequest object
   * @throws Exception 
   */
  @ApiOperation(value = "Registry a new user")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Registry successfull"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 500, message = "Error in database")})
  @PostMapping(value = "${api.registry}")
  public ResponseEntity<Void> registry(@RequestBody RegistryRequest request) throws Exception {
    registryService.registry(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  
  /**
   * Method to make a login.
   * 
   * @param request The CredentialsRequest object 
   */
  @PostMapping(value = "${api.login}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Login with credentials")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "User validation Successfull"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 401, message = "User not authorized"),
          @ApiResponse(code = 500, message = "Error in database")})
  public ResponseEntity<LoginResponse> login(@RequestBody CredentialsRequest request) {
    return new ResponseEntity<>(loginService.login(request), HttpStatus.OK);
  }
  
  /**
   * Method to make an update a user.
   * 
   * @param request The CredentialsRequest object 
   */
  @PutMapping(value = "${api.update}")
  @ApiOperation(value = "Update the password")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Update user Successfull"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 404, message = "User not found"),
          @ApiResponse(code = 500, message = "Error in database")})
  public ResponseEntity<Void> update(@RequestBody CredentialsRequest request) {
	  updateService.update(request);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
  
  /**
   * Method to delete a user.
   * 
   * @param request The DeleteRequest object 
   */
  @PostMapping(value = "${api.delete}")
  @ApiOperation(value = "Delete a user")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Delete user Successfull"),
          @ApiResponse(code = 400, message = "Bad Request"),
          @ApiResponse(code = 404, message = "User not found"),
          @ApiResponse(code = 500, message = "Error in database")})
  public ResponseEntity<Void> delete(@RequestBody DeleteSecurityRequest request) {
	  deleteService.delete(request);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
  
  @GetMapping(value = "${api.get}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Get users")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Get users Successfull"),
          @ApiResponse(code = 404, message = "Users not found"),
          @ApiResponse(code = 500, message = "Error in database")})
  public ResponseEntity<List<ViewUser>> retrieve() {
	  return new ResponseEntity<>(retrieveService.retrieveUsers(), HttpStatus.OK);
  }
  
}
