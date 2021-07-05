package com.adswaresystem.clever.hotelier.clients.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class Reservation {
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The credentialId attribute.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Integer reservationId;

    /**
     * The userId attribute.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id", nullable = false)
    private Room roomId;

    /**
     * The username attribute.
     */
    @Column(name = "client_name", nullable = false, length = 100)
    private String clientName;

    /**
     * The startDate attribute.
     */
    @Column(name = "start_date", nullable = false, length = 50)
    private String startDate;

    /**
     * The endDate attribute.
     */
    @Column(name = "end_date", nullable = false, length = 50)
    private String endDate;

    /**
     * The payedOut attribute.
     */
    @Column(name = "payed_out", nullable = false)
    private boolean payedOut;
}
