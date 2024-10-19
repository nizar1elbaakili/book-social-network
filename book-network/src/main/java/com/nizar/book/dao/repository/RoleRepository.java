package com.nizar.book.dao.repository;

import com.nizar.book.dao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {


    Optional<Role> findByName(String role);
}
