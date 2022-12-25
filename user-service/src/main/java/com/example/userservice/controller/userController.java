package com.example.userservice.controller;

import com.example.userservice.model.Room;
import com.example.userservice.request.ReqRoom;
import com.example.userservice.response.resRoom;
import com.example.userservice.response.resRoomSuccess;
import com.example.userservice.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class userController
{
    @Autowired
    RoomServiceImpl roomService;

    @PostMapping("/room/save")
    ResponseEntity<resRoom> saveRoom(@RequestBody Room room)
    {
        return roomService.saveRoom(room);
    }

    @GetMapping("/test")
    public String test()
    {
        return "This working";
    }


    @PutMapping("/room/update")
    ResponseEntity<resRoom> updateRoom(@RequestBody ReqRoom ReqRoom)
    {
        return roomService.updateRoom(ReqRoom);
    }

    @DeleteMapping("/room/delete/{roomId}")
    ResponseEntity<resRoomSuccess> delteRoom(@PathVariable("roomId") String roomId)
    {
        return roomService.deleteRoom(Long.valueOf(roomId));
    }

    @GetMapping("/room/getRoom/{roomId}")
    ResponseEntity<resRoom> getRoom(@PathVariable("roomId") String roomId)
    {
        return roomService.getRoom(Long.valueOf(roomId));
    }

    @GetMapping("/room/{userId}")
    ResponseEntity<resRoom> getRooms(@PathVariable("userId") String userId)
    {
        return roomService.getRooms(Long.valueOf(userId));
    }


}
