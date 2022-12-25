package com.example.device.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class resDeviceSuccess
{
    private Integer code;
    private String status;
    private String message;
}
