package com.adsware.repository;

import com.adswaresystem.clever.hotelier.clients.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByRoomKey(final String key);
}

