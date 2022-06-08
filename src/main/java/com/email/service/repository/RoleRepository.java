package com.email.service.repository;

import com.email.service.datamodel.ERole;
import com.email.service.datamodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByName(ERole role);

}
