package com.adswaresystem.clever.hotelier.clients.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ApiModel(description = "Reservation that will be shown")
public class ReservationsRequest {

    /**
     * The username attribute.
     */
    @NotNull(message = "The roomId is required")
    private int roomId;

    /**
     * The password attribute.
     */
    @NotNull(message = "The startDate is required")
    @NotBlank(message = "The startDate not must be blank")
    @NotEmpty(message = "The startDate not must be empty")
    private String startDate;

    /**
     * The email attribute.
     */
    @NotNull(message = "The endDate is required")
    @NotBlank(message = "The endDate not must be blank")
    @NotEmpty(message = "The endDate not must be empty")
    private String endDate;

    /**
     * The middleName attribute.
     */
    @NotNull(message = "The clientName is required")
    @NotBlank(message = "The clientName not must be blank")
    @NotEmpty(message = "The clientName not must be empty")
    private String clientName;

    /**
     * The userRole attribute.
     */
    @NotNull(message = "The payedOut is required")
    private boolean payedOut;
}
