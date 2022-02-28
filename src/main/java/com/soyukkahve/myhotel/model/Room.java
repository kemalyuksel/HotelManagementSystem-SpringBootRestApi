package com.soyukkahve.myhotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

