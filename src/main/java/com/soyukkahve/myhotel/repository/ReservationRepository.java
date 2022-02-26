package com.soyukkahve.myhotel.repository;

import com.soyukkahve.myhotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {



}
