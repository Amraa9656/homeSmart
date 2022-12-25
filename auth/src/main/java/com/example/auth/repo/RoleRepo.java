package com.example.auth.repo;

import com.example.auth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long>
{
    Role findByName(String name);
}
