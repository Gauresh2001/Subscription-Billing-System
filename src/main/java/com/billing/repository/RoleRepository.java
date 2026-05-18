package com.billing.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.billing.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
