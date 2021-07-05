package com.adsware.repository;

import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<RoomRate, Integer> {

}
