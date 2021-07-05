package com.adswaresystem.factory;

import com.adswaresystem.clever.hotelier.clients.entity.Room;
import com.adswaresystem.clever.hotelier.clients.entity.RoomRate;
import com.adswaresystem.clever.hotelier.clients.model.GenericObjectRequest;
import com.adswaresystem.clever.hotelier.clients.model.RoomRateRequest;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ObjectFactory {

    public static Room createRoom() {
        Room room = new Room();

        room.setRoomId(1);
        room.setRoomKey("B1");
        room.setRoomTypeId(1);

        return room;
    }

    public static RoomRateRequest createRoomRateRequest() {
        return RoomRateRequest.builder()
                .rate(400.58)
                .rateDescription("habitacion doble")
                .roomId(1)
                .build();
    }

    public static RoomRateRequest createRoomRateMalformedRequest() {
        return RoomRateRequest.builder()
                .rate(0.0)
                .rateDescription("")
                .roomId(0)
                .build();
    }

    public static RoomRate createRoomRate() {
        return RoomRate.builder()
                .roomRateId(1)
                .rate(400.58)
                .rateDescription("habitacion doble")
                .roomId(createRoom())
                .build();
    }

    public static GenericObjectRequest createGenericObjectRequest(final int id) {
        GenericObjectRequest request = new GenericObjectRequest();
        request.setElementId(id);
        return request;
    }

    public static List<RoomRate> createRatesList() {
        RoomRate request = RoomRate.builder()
                .roomRateId(1)
                .rateDescription("4 horas")
                .rate(300.00)
                .roomId(createRoom())
                .build();
        List<RoomRate> response = new ArrayList<>();
        response.add(request);

        return response;
    }

}
