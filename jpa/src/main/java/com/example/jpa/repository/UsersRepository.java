package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adswaresystem.clever.hotelier.clients.entity.Users;

/**
 * The interface UsersRepository.
 * 
 * @author AdsWare System
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

	/**
     * Method findByNameAndMiddleNameAndLastName.

     * @param name the middleName
     * @param middleName the middleName
     * @param lastName the lastName
     *
     * @return the object Users
     */
	Optional<Users> findByNameAndMiddleNameAndLastName(String name, String middleName, String lastName);
	
	/**
     * Method findByUserRole.

     * @param userRole the userRole
     *
     * @return the object Users
     */
	Optional<List<Users>> findByUserRole(Integer userRole);

}
