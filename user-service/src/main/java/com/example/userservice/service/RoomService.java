package com.example.userservice.service;

import com.example.userservice.model.Room;
import com.example.userservice.request.ReqRoom;
import com.example.userservice.response.resRoom;
import com.example.userservice.response.resRoomSuccess;
import org.springframework.http.ResponseEntity;

public interface RoomService
{
    ResponseEntity<resRoom> saveRoom(Room room);

    ResponseEntity<resRoom> getRoom(Long roomId);

    ResponseEntity<resRoom> getRooms(Long userId);

    ResponseEntity<resRoomSuccess> deleteRoom(Long roomId);

    ResponseEntity<resRoom> updateRoom(ReqRoom reqRoom);

}
