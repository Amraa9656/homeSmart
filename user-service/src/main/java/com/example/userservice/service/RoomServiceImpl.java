package com.example.userservice.service;

import com.example.userservice.model.Device;
import com.example.userservice.model.Room;
import com.example.userservice.repo.roomRepo;
import com.example.userservice.request.ReqRoom;
import com.example.userservice.response.resRoom;
import com.example.userservice.response.resRoomSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class RoomServiceImpl implements RoomService
{
    @Autowired
    roomRepo repo;


    @Override
    public ResponseEntity<resRoom> saveRoom(Room room)
    {
        resRoom res = new resRoom();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("");
            res.setData(repo.save(room));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resRoom> getRoom(Long roomId)
    {
        resRoom res = new resRoom();
        try
        {
            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");
            res.setData(repo.findById(roomId));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }

        return ResponseEntity.ok().body(res);
    }

    @Override
    public ResponseEntity<resRoom> getRooms(Long userId)
    {
        resRoom res = new resRoom();
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
    public ResponseEntity<resRoomSuccess> deleteRoom(Long roomId)
    {
        resRoomSuccess res = new resRoomSuccess();
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
    public ResponseEntity<resRoom> updateRoom(ReqRoom reqRoom)
    {
        resRoom res = new resRoom();
        try
        {
            Room room = new Room();
            room.setId(reqRoom.getId());
            room.setRoomType(reqRoom.getRoomType());
            room.setUserid(reqRoom.getUserid());
            room.setLightningValue(reqRoom.getLightningValue());
            room.setTemperatureValue(reqRoom.getTemperatureValue());


            Device device = new Device();
            device.setId(reqRoom.getDeviceId());
            device.setDeviceName(reqRoom.getDeviceName());
            device.setUserid(reqRoom.getUserid());
            device.setRoomid(reqRoom.getId());
            if (reqRoom.getLightningValue() > 5 && reqRoom.getDeviceName().equals("Lightning"))
            {
                device.setStatus(1);
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<Device> request = new HttpEntity<>(device);
                ResponseEntity<?> response = restTemplate.exchange("http://localhost:8081/device-service/api/device/update" ,
                        HttpMethod.PUT,request, resRoom.class );
            }
            else if (reqRoom.getLightningValue() <= 5 && reqRoom.getDeviceName().equals("Lightning"))
            {
                device.setStatus(0);
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<Device> request = new HttpEntity<>(device);
                ResponseEntity<?> response = restTemplate.exchange("http://localhost:8081/device-service/api/device/update" ,
                        HttpMethod.PUT,request, resRoom.class );
            }

            if (reqRoom.getTemperatureValue() > 5 && reqRoom.getDeviceName().equals("Heater"))
            {
                device.setStatus(1);
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<Device> request = new HttpEntity<>(device);
                ResponseEntity<?> response = restTemplate.exchange("http://localhost:8081/device-service/api/device/update" ,
                        HttpMethod.PUT,request, resRoom.class );
            }
            else if (reqRoom.getTemperatureValue() <= 5 && reqRoom.getDeviceName().equals("Heater"))
            {
                device.setStatus(0);
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<Device> request = new HttpEntity<>(device);
                ResponseEntity<?> response = restTemplate.exchange("http://localhost:8081/device-service/api/device/update" ,
                        HttpMethod.PUT,request, resRoom.class );
            }

            res.setCode(200);
            res.setStatus("Success");
            res.setMessage("Success");
            res.setData(repo.save(room));

        }catch (Exception e)
        {
            res.setCode(301);
            res.setStatus("Fail");
            res.setMessage(e.getMessage());
        }
        return ResponseEntity.ok().body(res);
    }
}
