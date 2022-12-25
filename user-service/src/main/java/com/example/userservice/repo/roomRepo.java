package com.example.userservice.repo;

import com.example.userservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface roomRepo extends JpaRepository<Room, Long>
{
    List<Room> findByUserid(long userid);
}
