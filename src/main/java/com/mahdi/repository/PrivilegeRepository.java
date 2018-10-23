package com.mahdi.repository;

import com.mahdi.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {

    Privilege findPrivilegeByPrivilegeId(Long id);
    Privilege findPrivilegeByName(String name);
}
