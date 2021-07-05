package com.adswaresystem.clever.hotelier.clients.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class RoomRateRequest {

    /**
     * The roomId attribute.
     */
    @NotNull
    private int roomId;

    /**
     * The rateDescription attribute.
     */
    @NotNull
    private String rateDescription;

    /**
     * The roomRate attribute.
     */
    @NotNull
    private Double rate;

}
