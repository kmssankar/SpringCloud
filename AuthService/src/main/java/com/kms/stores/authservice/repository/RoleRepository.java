package com.kms.stores.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kms.stores.authservice.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
