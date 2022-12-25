package com.example.device.service;

import com.example.device.model.Device;
import com.example.device.repo.deviceRepo;
import com.example.device.response.resDevice;
import com.example.device.response.resDeviceSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class DeviceServiceImpl implements DeviceService
{
    @Autowired
    deviceRepo repo;


    @Override
    public ResponseEntity<resDevice> saveDevice(Device device)
    {
        resDevice res = new resDevice();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("");
            res.setData(repo.save(device));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resDevice> getDevice(Long deviceId)
    {
        resDevice res = new resDevice();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");
            res.setData(repo.findById(deviceId));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resDevice> getDevices(Long userId)
    {
        resDevice res = new resDevice();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");
            res.setData(repo.findByUserid(userId));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resDeviceSuccess> deleteDevice(Long roomId)
    {
        resDeviceSuccess res = new resDeviceSuccess();
        try
        {
            repo.deleteById(roomId);
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resDevice> updateDevice(Device device)
    {
        resDevice res = new resDevice();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");
            res.setData(repo.save(device));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(res);
    }
}
