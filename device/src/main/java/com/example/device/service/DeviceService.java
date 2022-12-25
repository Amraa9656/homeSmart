package com.example.device.service;

import com.example.device.model.Device;
import com.example.device.response.resDevice;
import com.example.device.response.resDeviceSuccess;
import org.springframework.http.ResponseEntity;

public interface DeviceService
{
    ResponseEntity<resDevice> saveDevice(Device device);

    ResponseEntity<resDevice> getDevice(Long deviceId);

    ResponseEntity<resDevice> getDevices(Long userId);

    ResponseEntity<resDeviceSuccess> deleteDevice(Long roomId);

    ResponseEntity<resDevice> updateDevice(Device device);

}
