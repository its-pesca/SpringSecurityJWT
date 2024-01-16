package com.khaoula.securityservice.repositories;

import com.khaoula.securityservice.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByRoleName(String roleName);
}
