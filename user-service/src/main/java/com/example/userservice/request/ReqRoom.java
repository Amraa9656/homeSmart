package com.example.userservice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqRoom
{
    private Long id;
    private Long userid;
    private String roomType;
    private Integer temperatureValue;
    private Integer lightningValue;
    private Long deviceId;
    private String deviceName;
}
