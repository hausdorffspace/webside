package com.shop.demo.repository;

import com.shop.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
