package com.example.auth.repo;


import com.example.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>
{
    User findByUsername (String username);
}
