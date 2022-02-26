package com.soyukkahve.myhotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String roomType;
    private String maintenance;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enabled;
    private double price;
    private int bedAmount;

    // Fotoğraf alanı ?
    // Ekipmanlar ?

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private Set<Reservation> reservations;


}

