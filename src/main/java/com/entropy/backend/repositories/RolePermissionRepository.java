package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Byte> {
}
