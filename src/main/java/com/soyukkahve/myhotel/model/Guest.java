package com.soyukkahve.myhotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String phoneNumber;

    @Column(unique=true)
    private String email;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName="id")
    private User user;

    @OneToMany(mappedBy = "guest", fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "guest")
    private List<Invoice> bills;

}
