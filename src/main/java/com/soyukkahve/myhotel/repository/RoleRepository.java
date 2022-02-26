package com.soyukkahve.myhotel.repository;

import com.soyukkahve.myhotel.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleByName(String name);

}
