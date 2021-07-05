package com.adswaresystem.clever.hotelier.clients.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel(description = "Object id that will be delete")
public class GenericObjectRequest {

    /** The user attribute. */
    @NotNull(message = "The id is required")
    @NotBlank(message = "The id not must be blank")
    @NotEmpty(message = "The id not must be empty")
    private Integer elementId;
}
