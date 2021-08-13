package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Byte> {
}
