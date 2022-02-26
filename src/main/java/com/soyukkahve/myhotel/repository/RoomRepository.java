package com.soyukkahve.myhotel.repository;

import com.soyukkahve.myhotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
