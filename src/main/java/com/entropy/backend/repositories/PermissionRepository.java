package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Byte> {
}
