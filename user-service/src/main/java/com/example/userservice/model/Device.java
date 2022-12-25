package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Device
{
    private Long id;
    private Long userid;
    private Long roomid;
    private String deviceName;
    private Integer status;
}
