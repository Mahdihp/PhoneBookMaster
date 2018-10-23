package com.mahdi.repository;

import com.mahdi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleId(Long id);
    Role findRoleByName(String name);
}
