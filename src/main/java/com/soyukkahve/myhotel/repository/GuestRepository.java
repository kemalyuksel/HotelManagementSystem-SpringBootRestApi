package com.soyukkahve.myhotel.repository;

import com.soyukkahve.myhotel.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
