package com.adswaresystem.clever.hotelier.clients.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Products that will be stored in stock")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The application-specific product ID")
    private Integer productId;

    @ApiModelProperty(notes = "The application-specific product barcode")
    private String barCode;

    @ApiModelProperty(notes = "The application-specific product name")
    private String productName;

    @ApiModelProperty(notes = "The application-specific product description")
    private String productDescription;

    @ApiModelProperty(notes = "The application-specific number of the same product")
    private int inStock;

    @ApiModelProperty(notes = "The application-specific min number of the same product")
    private int minCapacity;

    @ApiModelProperty(notes = "The application-specific product selling cost")
    private double sell_price;

    @ApiModelProperty(notes = "The application-specific product buying cost")
    private double buy_price;

    @ApiModelProperty(notes = "The application-specific operation type")
    private char operation_Type;

    @ApiModelProperty(notes = "The application-specific product image")
    @Lob
    private byte[] image_code;

    @ApiModelProperty(notes = "The application-specific category identificator")
    private int productCategoryId;

    @ApiModelProperty(notes = "The application-specific subcategory identificator")
    private int subcategoryId;

    @ApiModelProperty(notes = "The application-specific providers")
    private int providerId;

    @ApiModelProperty(notes = "The application-specific stock")
    private int stockId;
    
}
