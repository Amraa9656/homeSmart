package com.example.device.controller;


import com.example.device.model.Device;
import com.example.device.response.resDevice;
import com.example.device.response.resDeviceSuccess;
import com.example.device.service.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class deviceController
{
    @Autowired
    DeviceServiceImpl deviceService;

    @PostMapping("/device/save")
    ResponseEntity<resDevice> saveDevice(@RequestBody Device device)
    {
        return deviceService.saveDevice(device);
    }

    @PutMapping("/device/update")
    ResponseEntity<resDevice> updateRoom(@RequestBody Device device)
    {
        return deviceService.updateDevice(device);
    }

    @DeleteMapping("/device/delete/{deviceId}")
    ResponseEntity<resDeviceSuccess> delteRoom(@PathVariable("deviceId") String deviceId)
    {

        return deviceService.deleteDevice(Long.valueOf(deviceId));
    }

    @GetMapping("/device/getDevice/{deviceId}")
    ResponseEntity<resDevice> getRoom(@PathVariable("deviceId") String roomId)
    {
        return deviceService.getDevice(Long.valueOf(roomId));
    }

    @GetMapping("/room/{userId}")
    ResponseEntity<resDevice> getRooms(@PathVariable("userId") String userId)
    {
        return deviceService.getDevices(Long.valueOf(userId));
    }


}
