package com.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRolename(String role);
}
