package com.soyukkahve.myhotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User user;

    @OneToMany(mappedBy = "guest", fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "guest")
    private List<Invoice> bills;

    public Guest() {
    }

    public Guest(String name, String surname, String phoneNumber, String email, User user) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
    }
}
