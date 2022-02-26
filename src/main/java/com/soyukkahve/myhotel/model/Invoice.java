package com.soyukkahve.myhotel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;


    public Invoice(Date billingDate, double price, Guest guest) {
        this.billingDate = billingDate;
        this.price = price;
        this.guest = guest;
    }

    public Invoice() {
    }
}
