package com.adswaresystem.clever.hotelier.clients.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
public class RoomRate {
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The room id attribute.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_rate_id")
    private Integer roomRateId;

    /**
     * The roomId attribute.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id", nullable = false)
    private Room roomId;

    /**
     * The rateDescription attribute.
     */
    @Column(name = "rate_description", nullable = false)
    private String rateDescription;

    /**
     * The roomRate attribute.
     */
    @Column(name = "room_rate", nullable = false)
    private Double rate;

}
