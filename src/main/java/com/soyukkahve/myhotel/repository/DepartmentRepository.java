package com.soyukkahve.myhotel.repository;

import com.soyukkahve.myhotel.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
