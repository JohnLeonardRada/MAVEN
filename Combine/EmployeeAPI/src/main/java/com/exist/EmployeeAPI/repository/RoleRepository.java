package com.exist.EmployeeAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exist.EmployeeAPI.model.Role;
import com.exist.EmployeeAPI.reference.ERole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
