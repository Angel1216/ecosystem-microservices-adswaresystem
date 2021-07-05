package com.adswaresystem.clever.hotelier.clients.entity;

import lombok.*;

import javax.persistence.*;
//import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerName;

    private String customerMiddleName;

    private String customerLastName;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
//    private Set<CustomerAddress> addresses;

    private String customerEmail;

    private String customerPhoneNumber;

    private String customerTaxId;

}
