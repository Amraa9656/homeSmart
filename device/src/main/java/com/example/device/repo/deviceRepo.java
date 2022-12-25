package com.example.device.repo;

import com.example.device.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface deviceRepo extends JpaRepository<Device, Long>
{
    List<Device> findByUserid(long userid);
}
