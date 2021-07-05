package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.WelcomeEntity;

public interface WelcomeRepository extends JpaRepository<WelcomeEntity, Integer> {

}
