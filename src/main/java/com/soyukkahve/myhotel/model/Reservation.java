package com.soyukkahve.myhotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date entryDate;
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable=false)
    private Room room;

    public Reservation(Date entryDate, Date releaseDate, Guest guest, Room room) {
        this.entryDate = entryDate;
        this.releaseDate = releaseDate;
        this.guest = guest;
        this.room = room;
    }

    public Reservation() {
    }
}
